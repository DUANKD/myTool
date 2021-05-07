package com.mytool.file;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class ReadFileUtilTest {

    @Test
    public void readTest() {
        int bufSize = 1000000;//一次读取的字节长度  
        File fileIn = new File("D:\\test\\20160622_627975.txt");//读取的文件
        File fileOut = new File("D:\\test\\20160622_627975_1.txt");//写出的文件
        Date startDate = new Date();
        FileChannel fileChannelIn = null;
        ByteBuffer readBuffer = ByteBuffer.allocate(bufSize);
        FileChannel fileChannelOut = null;
        try {
            fileChannelIn = new RandomAccessFile(fileIn, "r").getChannel();
            fileChannelOut = new RandomAccessFile(fileOut, "rws").getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteBuffer writeBuffer = ByteBuffer.allocateDirect(bufSize);

        ReadFileUtil.readFileByLine(bufSize, fileChannelIn, readBuffer, fileChannelOut, writeBuffer);
        Date endDate = new Date();

        System.out.print(startDate + "|" + endDate);//测试执行时间
        try {
            if (fileChannelIn.isOpen()) {
                fileChannelIn.close();
            }
            if (fileChannelOut.isOpen()) {
                fileChannelOut.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}