package com.mytool.base.utils;

import cn.hutool.extra.spring.SpringUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MyFileUtilTest {

    @Test
    void getFromFile() {
        String fileName = "testFiles/result_basics_user_info_20210118.txt";
        List<String> result = MyFileUtil.getFromFile(fileName);
        System.out.println(result.size());
    }

    @Test
    void getLongListFromIndex() {
        String fileName = "testFiles/result_basics_user_info_20210118.txt";
        List<Long> result = MyFileUtil.getLongListFromIndex(fileName, 1389783);
        System.out.println(result.size());
        //
    }



    @Test
    void getFromTxtFile() {
        String fileName = "testFiles/spring_marketing.txt";
        List<String> result = MyFileUtil.getFromFile(fileName);
        System.out.println(result.size());
    }


    /**
     * 流式读取
     */
    @Test
    void name() {
        String fileName = "/testFiles/spring_marketing.txt";
        //String fileName = "com/mytool/file/spring_marketing.txt";
        List<String> dataVOList = new ArrayList<>();
        try {
            //FileReader fr = new FileReader(fileName);
            //File file = new File(fileName);
            //InputStream inputStream = this.getClass().getResourceAsStream(fileName);
            InputStream inputStream = MyFileUtil.class.getResourceAsStream(fileName);
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader bf = new BufferedReader(inputReader);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                dataVOList.add(str);
            }
            bf.close();
            inputStream.close();
            //fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dataVOList.size());
    }

    @Test
    void getLongListFromStartIndex() {
        String fileName = "testFiles/result_basics_user_info_20210118.txt";
        List<List<Long>> result = MyFileUtil.getLongListFromStartIndex(fileName,1,100);
        System.out.println(result.size());
    }
}