package com.hzxy.admin.web.controller.upload;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Auther:lwq
 * @Date:2019/3/6
 * @Description:com.hzxy.admin.web.controller.upload
 * @version:1.0
 */
@RestController
public class ImgUpload {
    private static final String PATH="/static/upload/image/";
    String path="E:\\javaPro\\project\\maven\\language2\\admin\\src\\main\\resources\\static\\upload\\image\\";

    @RequestMapping(value="/uploadimg", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) throws FileNotFoundException {
      /*String path = request.getServletContext().getRealPath("WEB-INF/upload/images/");

        System.out.println("dagdg:"+path);*/
        //文件存放路径


        File fileP= new File(path);

      if(!fileP.exists())
          fileP.mkdir();


        String fileName = file.getOriginalFilename();  //图片名字


        String filePath=path;

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
             filePath= FileUtil.uploadFile(file.getBytes(), filePath, fileName);

           filePath=filePath.substring(filePath.lastIndexOf("\\") + 1);
        } catch (Exception e) {
            // TODO: handle exception
        }

        //ip地址
        String host=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();

        // 返回图片的存放路径
        return host+PATH+filePath;
    }


}
