package com.mytool.base.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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


    /**
     * 的撒
     *
     * @param fileName
     * @return
     */
    public static List<String> getFromFile(String fileName) {
        try {
            //默认UTF-8编码，可以在构造中传入第二个参数做为编码
            FileReader fileReader = new FileReader(fileName);
            List<String> result = fileReader.readLines();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static List<Long> getLongListFromIndex(String fileName, int index) {
        List<String> result = getFromFile(fileName);
        List<Long> longList = new ArrayList<>();
        if (result.size() >= index) {
            for (int i = index - 1; i < result.size(); i++) {
                longList.add(Long.valueOf(result.get(i)));
            }
        }
        return longList;
    }

    /**
     * 从1开始
     *
     * @param fileName
     * @param index
     * @return
     */
    public static List<List<Long>> getLongListFromStartIndex(String fileName, int index, int pageSize) {
        List<List<Long>> listList = new ArrayList<>();
        List<String> result = getFromFile(fileName);
        if (result != null && result.size() >= index) {
            int pageNum = result.size() / pageSize;
            for (int i = 0; i < pageNum; i++) {
                List<Long> longList = new ArrayList<>();
                for (int j = index - 1; j < result.size(); j++) {
                    longList.add(Long.valueOf(result.get(j)));
                }
                listList.add(longList);
                index += pageSize;
            }
        }
        return listList;
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
