package com.example.hello;

import com.example.hello.Util.FileUtil;
import com.qiniu.storage.model.DefaultPutRet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping(path = "/upload")
@RestController
public class UploadController {

    @Resource
    private UploadService uploadService;


    /**
     * 本地文件直接上传到七牛
     * @param fileName
     * @return
     */
    @RequestMapping(path = "/file")
    public DefaultPutRet uploadFile(@RequestParam(value="fileName", defaultValue="手机号段.csv") String fileName) {

        DefaultPutRet ret = uploadService.uploadLocalFile(fileName);
        return ret;
    }

    /**
     *
     * 文件保存到服务器端
     * @param file MultipartFile
     * @return IBusinessResult
     */
    @RequestMapping(path = "/pic", method = RequestMethod.POST)
    public String uploadPic(@RequestParam("file") MultipartFile file) {

        if (null == file || file.isEmpty()) {
            return ("文件不能为空");
        }
        //初始化输入流
        InputStream ins = null;
        try {
            //文件对象得到文件输入流
            ins = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null != file.getOriginalFilename()) {
            //准备好待存储的文件对象
            File dest = new File(file.getOriginalFilename());
            //保存到文件里
            FileUtil.inputStreamToFile(ins, dest);
            return "success";
        } else {
            return "上传图片失败";
        }
    }

    /**
     *
     * 文件保存到七牛
     * @param file MultipartFile
     * @return IBusinessResult
     */
    @RequestMapping(path = "/remote", method = RequestMethod.POST)
    public DefaultPutRet uploadQiniu(@RequestParam("file") MultipartFile file) {

        //开始一段检测
        if (null == file || file.isEmpty()) {
            System.out.println("文件不能为空");
        }
        //初始化输入流
        InputStream ins = null;
        try {
            //文件对象得到文件输入流
            ins = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获得一个文件名  日期+小时+随机
        String fname = FileUtil.getRandName(file.getOriginalFilename());
        return uploadService.uploadInputStream(ins,fname);
    }
}