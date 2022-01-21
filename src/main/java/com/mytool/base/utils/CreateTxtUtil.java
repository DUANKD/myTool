package com.mytool.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CreateTxtUtil {
    private static Logger logger = LoggerFactory.getLogger(CreateTxtUtil.class);

    private static String FILE_DIR = "C:/Users/Administrator/Desktop/";
    private static String TMP_FILE_DIR = "";

    public static String createDataListTxtFile(List<String> dataList) {
        String path = "whitelist.txt";
        File file = new File(FILE_DIR + path);
        /*if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        file.setExecutable(true);*/
        String filePath = null;
        try {
            filePath = stringBufferWrite(file, dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public static String createDataListTxtFile(String fileName, List<String> dataList) {
        File file = new File(FILE_DIR + fileName);
        String filePath = null;
        try {
            filePath = stringBufferWrite(file, dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }


    public static String stringBufferWrite(File file, List<String> dataList) throws IOException {
        file = initFile(file);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bf = new BufferedWriter(fw);
        for (int i = 0; i < dataList.size(); i++) {
            try {
                bf.write(dataList.get(i));
                //if (i < whiteList.size() - 1) { //}
                bf.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bf.flush();
        bf.close();
        return file.getAbsolutePath();
    }

    private static File initFile(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            initFilePermission(file.getParentFile());
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                initFilePermission(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        file.setExecutable(true);
        return file;
    }

    private File initDirs(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            initFilePermission(file.getParentFile());
        }
        if (!file.exists()) {
            file.mkdirs();
            initFilePermission(file);
        }
        file.setExecutable(true);
        return file;
    }

    private static File initFilePermission(File file) {
        try {
            Runtime.getRuntime().exec("chmod 777 " + file);
            changeFolderPermission(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static void changeFolderPermission(File dirFile) {
        Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        try {
            Path path = Paths.get(dirFile.getAbsolutePath());
            Files.setPosixFilePermissions(path, perms);
        } catch (Exception e) {
            logger.error("Change folder " + dirFile.getAbsolutePath() + " permission failed.", e);
        }
    }
}
