package com.example.hello;

import com.example.hello.Util.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/attachment")
@RestController
public class DownloadController {

    @Resource
    private DownloadService downloadService;

    /**
     * 查看图片或下载文件
     * @param file
     * @param name
     * @param response
     */
    @RequestMapping("/view")
    public void view(@RequestParam("file") String file, @RequestParam("name") String name,HttpServletResponse response) {
        // 图片
        if (FileUtil.checkFileTypeImage(file)) {
            viewPic(file,response);
        } else {
            downFile(file,response,name);
        }
    }

    /**
     *  查看图片，不下载
     * @param file
     * @param response
     */
    private void viewPic(String file,HttpServletResponse response) {
        downloadService.viewPic(file,response);
    }

    /**
     * 下载非图片文件
     * @param file
     * @param response
     * @param name
     */
    private void downFile(String file,HttpServletResponse response,String name) {
        downloadService.downFile(file,response,name);
    }
}
