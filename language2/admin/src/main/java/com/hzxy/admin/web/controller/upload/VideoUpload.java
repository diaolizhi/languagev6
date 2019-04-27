package com.hzxy.admin.web.controller.upload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Auther:lwq
 * @Date:2019/3/6
 * @Description:com.hzxy.admin.web.controller.upload
 * @version:1.0
 */
@RestController
public class VideoUpload {
    private static final String PATH="/static/upload/mp4/";
    String path="E:\\javaPro\\project\\maven\\language2\\admin\\src\\main\\resources\\static\\upload\\mp4\\";

    @RequestMapping(value="/uploadvideo", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file,
                            HttpServletRequest request) {

       /* String path = request.getServletContext().getRealPath("WEB-INF/upload/file/");*/

        File savePath= new File(path);

        if(!savePath.exists())
            savePath.mkdir();

        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字


        //文件存放路径
        String filePath = path;

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            filePath= FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            filePath=filePath.substring(filePath.lastIndexOf("\\") + 1);
        } catch (Exception e) {
            // TODO: handle exception
        }

        String host=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();

        // 返回图片的存放路径
        return host+PATH+filePath;
    }
}
