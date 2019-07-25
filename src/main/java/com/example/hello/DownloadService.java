package com.example.hello;

import com.example.hello.Util.HttpClientUtil;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class DownloadService {


    @Value("${qiniu.bucket.domain}")
    private String domainOfBucket;


    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;


    /**
     * 查看图片
     * @param file
     * @param response
     */
    public void viewPic(String file, HttpServletResponse response) {
        OutputStream out = null;
        String resourceUrl = getUrl(file);

        // 需要映射对应的图片类型，目前固定
        response.setContentType("image/png");
        response.setHeader("Accept-Ranges","bytes");
        response.setHeader("Content-Transfer-Encoding","binary");
        response.setHeader("Access-Control-Allow-Origin","*");

        // 获得response对象的输出流
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpClientUtil.download(resourceUrl,out);
    }

    /**
     * 下载文件
     * @param file
     * @param response
     * @param name
     */
    public void downFile(String file, HttpServletResponse response,String name) {
        OutputStream out = null;
        //获得真正url
        String resourceUrl = getUrl(file);

        //设置响应header
        response.setHeader("Content-disposition", "attachment; filename=\"" + name + "\"");
        response.setContentType("application/octet-stream");

        // 获得response对象的输出流
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpClientUtil.download(resourceUrl,out);
    }

    /**
     * 拼接主域名,
     * 如果是私有空间，需要生成token
     * @param fileName
     * @return
     */
    private String getUrl(String fileName) {

        //格式化代码
        String publicUrl = String.format("%s/%s", domainOfBucket, fileName);

        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println("qiniuURL是" + finalUrl);
        return finalUrl;
    }
}
