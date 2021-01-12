package com.mytool.base.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author duankd
 * @ClassName MyFileUtil
 * @date 2020-12-22 9:53:47
 */
public class MyFileUtil {

    /**
     * 的撒
     *
     * @param fileName
     * @return
     */
    public static String getFromInnerJson(String fileName) {
        InputStream inputStream = MyFileUtil.class.getResourceAsStream(fileName);
        //this.getClass().getResourceAsStream("/新旧栏目对应表.json");
        if (inputStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String tempOneLine = new String("");
                while ((tempOneLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append(tempOneLine);
                }

                return stringBuffer.toString();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        return null;
    }


    /**
     * 的撒
     *
     * @param fileName
     * @return
     */
    public static String getFromJson(String fileName) {
        try {
            //默认UTF-8编码，可以在构造中传入第二个参数做为编码
            FileReader fileReader = new FileReader(fileName);
            String result = fileReader.readString();
            return result;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public static String pushToFile(String message, String newFile) {
        try {
            FileWriter writer = new FileWriter(newFile);
            writer.write(message);
            return newFile;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String pushListToFile(List<String> messageList, String newFile) {
        try {
            FileWriter writer = new FileWriter(newFile);
            writer.writeLines(messageList);
            return newFile;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }


}
