package com.mytool.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duankd
 * @ClassName ReadFileUtil
 * @date 2021-05-07 14:59:16
 */
public class ReadFileUtil {

    /**
     * 读取文件
     *
     * @param bufSize
     * @param fileChannelIn
     * @param readBuffer
     * @param fileChannelOut
     * @param writeBuffer
     */
    public static void readFileByLine(int bufSize, FileChannel fileChannelIn,
                                      ByteBuffer readBuffer, FileChannel fileChannelOut, ByteBuffer writeBuffer) {
        String enter = "\n";
        //存储读取的每行数据
        List<String> dataList = new ArrayList<String>();
        byte[] lineByte = new byte[0];

        String encode = "GBK";
//      String encode = "UTF-8";
        try {
            long lineAllNum = 0L;
            //temp：由于是按固定字节读取，在一次读取中，第一行和最后一行经常是不完整的行，因此定义此变量来存储上次的最后一行和这次的第一行的内容，
            //并将之连接成完成的一行，否则会出现汉字被拆分成2个字节，并被提前转换成字符串而乱码的问题
            byte[] temp = new byte[0];
            while (fileChannelIn.read(readBuffer) != -1) {//fileChannelIn.read(readBuffer)：从文件管道读取内容到缓冲区(readBuffer)
                int rSize = readBuffer.position();//读取结束后的位置，相当于读取的长度
                byte[] bs = new byte[rSize];//用来存放读取的内容的数组
                readBuffer.rewind();//将position设回0,所以你可以重读Buffer中的所有数据,此处如果不设置,无法使用下面的get方法
                readBuffer.get(bs);//相当于readBuffer.get(bs,0,bs.length())：从position初始位置开始相对读,读bs.length个byte,并写入bs[0]到bs[bs.length-1]的区域
                readBuffer.clear();

                int startNum = 0;
                /**
                 * Unix系统里，每行结尾只有“<换行>”，即“\n”；
                 * Windows系统里面，每行结尾是“<回车><换行>”，即“\r\n”；
                 * Mac系统里，每行结尾是“<回车>”,即“\r”。
                 */
                //换行符 \n
                int LF = 10;
                //回车符 \r
                int CR = 13;
                boolean hasLF = false;//是否有换行符
                boolean hasCR = false;//是否有换行符
                for (int i = 0; i < rSize; i++) {
                    if (bs[i] == CR || bs[i] == LF) {
                        if (bs[i] == CR) {
                            hasCR = true;
                        } else if (i + 1 < rSize && bs[i + 1] == LF) {
                            hasLF = true;
                        }
                        if (bs[i] == LF) {
                            hasLF = true;
                        }
                        if (hasLF && hasCR) {
                            i--;
                        }
                        int tempNum = temp.length;
                        int lineNum = i - startNum;
                        //数组大小已经去掉换行符
                        lineByte = new byte[tempNum + lineNum];
                        //填充了lineByte[0]~lineByte[tempNum-1]
                        System.arraycopy(temp, 0, lineByte, 0, tempNum);
                        temp = new byte[0];
                        //填充lineByte[tempNum]~lineByte[tempNum+lineNum-1]
                        System.arraycopy(bs, startNum, lineByte, tempNum, lineNum);
                        //一行完整的字符串(过滤了换行和回车)
                        String line = new String(lineByte, 0, lineByte.length, encode);
                        dataList.add(line);
                        //打印
                        if (lineAllNum == 0) {
                            System.out.println(++lineAllNum + "行->" + line);
                        } else {
                            System.out.println(++lineAllNum + "行->" + Long.valueOf(line));
                        }

                        writeFileByLine(fileChannelOut, writeBuffer, line + enter);

                        //过滤回车符和换行符
                        if (i + 1 < rSize && bs[i + 1] == LF) {
                            startNum = i + 2;
                            //跳过下一个
                            i++;
                        } else {
                            startNum = i + 1;
                        }

                    }
                }
                if (hasLF || hasCR) {
                    if (hasLF && hasCR) {
                        startNum++;
                    }
                    temp = new byte[bs.length - startNum];
                    System.arraycopy(bs, startNum, temp, 0, temp.length);
                } else {
                    //兼容单次读取的内容不足一行的情况
                    byte[] toTemp = new byte[temp.length + bs.length];
                    System.arraycopy(temp, 0, toTemp, 0, temp.length);
                    System.arraycopy(bs, 0, toTemp, temp.length, bs.length);
                    temp = toTemp;
                }
            }
            if (temp != null && temp.length > 0) {
                //兼容文件最后一行没有换行的情况
                String line = new String(temp, 0, temp.length, encode);
                dataList.add(line);
                //打印
                if (lineAllNum == 0) {
                    System.out.println(++lineAllNum + "行->" + line);
                } else {
                    System.out.println(++lineAllNum + "行->" + Long.valueOf(line));
                }
                writeFileByLine(fileChannelOut, writeBuffer, line + enter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写到文件上
     *
     * @param fileChannelOut
     * @param writeBuffer
     * @param line
     */
    @SuppressWarnings("static-access")
    public static void writeFileByLine(FileChannel fileChannelOut, ByteBuffer writeBuffer,
                                       String line) {
        if (fileChannelOut == null) {
            return;
        }
        try {
            fileChannelOut.write(writeBuffer.wrap(line.getBytes("UTF-8")), fileChannelOut.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
