package com.example.hello.Util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Desc:    HTTP请求方式通用类
 * Author: Iron
 * CreateDate: 2017-11-02
 * CopyRight: Beijing Yunzong Co., Ltd.
 *
 * @author Iron
 */
@Slf4j
public final class HttpClientUtil {
    private HttpClientUtil() {
    }

    /**
     * org.apache.http.impl.client.CloseableHttpClient
     */
    private static CloseableHttpClient httpclient = null;

    /**
     * 根据url下载文件到本地
     *
     * @param resource String  资源url
     * @param fileName String  命名的文件
     * @return boolean
     */
    public static boolean download(String resource, String fileName) {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            URL url = new URL(resource);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            in = new DataInputStream(connection.getInputStream());
            out = new DataOutputStream(new FileOutputStream(fileName));
            return download(in, out);
        } catch (Exception e) {
            log.trace("-------> download_file_failed1." + e.getMessage());
            return false;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                log.trace("-------> download_file_failed2." + ex.getMessage());
            }
        }
    }

    /**
     * 根据url下载文件到输出流（一般提供客户端下载）
     *
     * @param resource String   资源地址
     * @param out      输出地址
     * @return boolean
     */
    public static boolean download(String resource, OutputStream out) {
        //此方法只能用户HTTP协议
        DataInputStream in = null;
        try {
            URL url = new URL(resource);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 获得输入流，从外部url读入本地
            in = new DataInputStream(connection.getInputStream());
            //再从本地转到输出流
            return download(in, out);
        } catch (Exception e) {
            log.trace("-------> download_file_failed1." + e.getMessage());
            return false;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                log.trace("-------> download_file_failed2." + ex.getMessage());
            }
        }
    }

    /**
     * 较为底层的方法
     *
     * @param inputStream  输入流
     * @param outputStream 输出流
     * @return boolean
     */
    public static boolean download(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[4096];
        int count;
        //读取buffer大小的字节到buffer
        while ((count = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, count);
        }
        return true;
    }


    /**
     */
    public static String doGet(String resource) {
        InputStream in = null;
        try {
            //建立url对象
            URL url = new URL(resource);
            //根据url对象创建连接对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 获得输入流，从外部url读入本地，这一步就会发送http请求
            in = connection.getInputStream();

            //需要一个桥梁InputStreamReader的适配到BufferedReader。
            // 网页数据是字符，所以用Reader不用stream
            BufferedReader br=new BufferedReader(new InputStreamReader(in));

            //接收的
            StringBuilder sb=new StringBuilder();
            String str=null;
            // BufferedReader到StringBuilder
            while((str=br.readLine())!=null){
                sb.append(str+"\n");
            }
            System.out.println(sb);
            return sb.toString();
        } catch (Exception e) {
            log.trace("-------> download_file_failed1." + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                log.trace("-------> download_file_failed2." + ex.getMessage());
            }
        }
        return "";
    }
}
