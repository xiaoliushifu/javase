package com.example.hello;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import java.io.InputStream;

@Component
public class UploadService {

    /**
     * 配合静态代码块
     */
    private static  Configuration cfg;
    private static UploadManager uploadManager;
    private static String upToken;
    private static  BASE64Decoder decoder;
    //静态代码块
    static {
        //构造一个带指定Zone对象的配置类
        cfg = new Configuration(Zone.zone1());
        uploadManager = new UploadManager(cfg);
        decoder = new BASE64Decoder();
    }


    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;


    /**
     * 把服务器上的文件（绝对路径）上传到七牛
     * @param fileName
     * @return
     */
    public DefaultPutRet uploadLocalFile(String fileName) {

        String localFilePath = "/Users/masterliu/Documents/" + fileName;

        //可以自定义文件名
        String key = fileName;
        String upToken = getUploadToken();
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 根据输入流保存到七牛
     * @param in
     * @param fileName
     * @return
     */
    public DefaultPutRet uploadInputStream(InputStream in,String fileName) {
        //可以自定义文件名
        String key = fileName;
        String upToken = getUploadToken();
        try {
            Response response = uploadManager.put(in, key, upToken,null,null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 获取上传的token
     * @return
     */
    private String getUploadToken() {
        if (upToken == null) {
            Auth auth = Auth.create(accessKey, secretKey);
            //生成token
            upToken = auth.uploadToken(bucket);
            return upToken;
        }
        //查看token过期时间
        String[] strArr = upToken.split(":",0);
        try {
            String s = new String(decoder.decodeBuffer(strArr[2]), "UTF-8");

            QiniuToken o = JSONObject.parseObject(s,QiniuToken.class);
            if (o.getDeadline() < ((int) System.currentTimeMillis()/1000) ) {
                Auth auth = Auth.create(accessKey, secretKey);
                upToken = auth.uploadToken(bucket);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return upToken;
    }
}
