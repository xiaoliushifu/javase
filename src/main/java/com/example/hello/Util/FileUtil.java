package com.example.hello.Util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    public static final int OFF=0;
    public static final int BYTE_LEN=8192;

    public static final int FILE_SIZE_LIMIT_FIVE_MB=5 * 1024 * 1024;

    public  static final String JPEG=".jpeg";
    public  static final String JPG=".jpg";
    public  static final String BMP=".bmp";
    public  static final String PNG=".png";


    public  static final String UNIT_B="B";
    public  static final String UNIT_K="K";
    public  static final String UNIT_M="M";
    public  static final String UNIT_G="G";

    /**
     * MultipartFile 转file
     * @param ins 输入流
     * @param file 目标文件
     */
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            //输出流和文件绑定
            OutputStream os = new FileOutputStream(file);
            int bytesRead = OFF;
            byte[] buffer = new byte[BYTE_LEN];
            //从OFF位置读取BYTE_LEN长度的字节到buffer中，自动移动偏移量
            while ((bytesRead = ins.read(buffer, OFF, BYTE_LEN)) != -1) {
                //向输出流写入，就是向文件写入
                os.write(buffer, OFF, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 检查文件大小是否符合要求
     *
     * @param file 文件对象
     * @param limitSize 限制大小
     * @param unit 单位
     * @return Boolean
     */
    public static Boolean checkFileSize(File file, int limitSize, String unit) {
        long len = file.length();
        double fileSize = 0;
        // 字节
        if (UNIT_B.equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if (UNIT_K.equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if (UNIT_M.equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if (UNIT_G.equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > limitSize) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否是图片
     *
     * @param fileName 文件名
     * @return
     */
    public static Boolean checkFileTypeImage(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (BMP.equalsIgnoreCase(fileExtension)) {
            return Boolean.TRUE;
        }
        if (JPEG.equalsIgnoreCase(fileExtension) || JPG.equalsIgnoreCase(fileExtension)) {
            return Boolean.TRUE;
        }
        if (PNG.equalsIgnoreCase(fileExtension)) {
            return Boolean.TRUE;
        }
        // 默认返回类型
        return Boolean.FALSE;
    }

    /**
     * 获得文件名的后缀
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getFileType(String fileName) {
        // 文件的后缀名
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 获得一个文件名  年月日时+时间戳+随机+原文件后缀
     * @param fileName
     * @return
     */
    public static String getRandName(String fileName) {
        //日期对象
        Date d = new Date();
        //格式化对象
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH");

        // 当前时间戳
        Long stamp = System.currentTimeMillis();

        //随机数字
        int max=999999,min=1;
        int ran = (int) (Math.random()*(max-min)+min);

        //拼接返回
        return df.format(d) + "/" + stamp + ran + getFileType(fileName);
    }
}
