package com.example.hello;

import com.example.hello.Util.FileUtil;
import com.example.hello.Util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RequestMapping("/attachment")
@RestController
public class DownloadController {


    @Value("${qiniu.bucket.domain}")
    private String domainOfBucket;

    /**
     * 查看图片或下载文件
     * @param file
     * @param name
     * @param response
     */
    @RequestMapping("/view")
    public void view(@RequestParam("file") String file, @RequestParam("name") String name,HttpServletResponse response) {
        OutputStream out = null;

        //获得真正url
        String resourceUrl = getUrl(file);
        // 图片
        if (FileUtil.checkFileTypeImage(file)) {
            viewPic(resourceUrl,response);
        } else {
            downFile(resourceUrl,response,name);
        }
    }

    /**
     *  查看图片，不下载
     * @param resourceUrl
     * @param response
     */
    private void viewPic(String resourceUrl,HttpServletResponse response) {
        OutputStream out = null;
        // 需要映射类型，目前固定
        response.setContentType("image/png");
        response.setHeader("Accept-Ranges","bytes");
        response.setHeader("Content-Transfer-Encoding","binary");
        response.setHeader("Access-Control-Allow-Origin","*");
        /* 获得response对象的输出流 */
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpClientUtil.download(resourceUrl,out);
    }

    /**
     * 下载非图片文件
     * @param resourceUrl
     * @param response
     * @param name
     */
    private void downFile(String resourceUrl,HttpServletResponse response,String name) {
        OutputStream out = null;

        //设置响应header
        response.setHeader("Content-disposition", "attachment; filename=\"" + name + "\"");
        response.setContentType("application/octet-stream");
        /* 获得response对象的输出流 */
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpClientUtil.download(resourceUrl,out);
    }

    /**
     * 拼接主域名,
     * 目前是公有空间，如果是私有空间，还需要生成token
     * @param fileName
     * @return
     */
    private String getUrl(String fileName) {
        //格式化代码
        String finalUrl = String.format("%s/%s", domainOfBucket, fileName);
        System.out.println("qiniuURL是" + finalUrl);
        return finalUrl;
    }
}
