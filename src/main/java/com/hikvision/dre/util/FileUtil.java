package com.hikvision.dre.util;


import org.apache.commons.lang3.RandomUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 09:44
 * @Description: 文件工具类
 */
public class FileUtil {

    /**
     * <p>将文件转成base64 字符串</p>
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        return encodeBase64File(getFile(path));
    }

    /**
     * 获取文件
     * @param path 文件路径
     * @return
     */
    public static File getFile(String path) {
        return new File(path);
    }

    /**
     * <p>将文件转成base64 字符串</p>
     * @param file 文件
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(File file) {
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            inputFile.read(buffer);
            return Base64.getEncoder().encodeToString(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputFile != null) {
                    inputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * 获取文件大小
     * @param file
     * @return
     */
    public static long getFileSize(File file) {
        return file.length();
    }

    /**
     * <p>将base64字符解码保存文件</p>
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code,String targetPath) {
        byte[] buffer = Base64.getDecoder().decode(base64Code);
        writeByteToFileOutPutStream(buffer, targetPath);
    }

    private static void writeByteToFileOutPutStream(byte[] buffer, String targetPath) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(targetPath);
            out.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
    }
}
