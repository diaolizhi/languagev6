package com.hzxy.admin.web.controller.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @Auther:lwq
 * @Date:2019/3/6
 * @Description:com.hzxy.admin.web.controller.upload
 * @version:1.0
 */
public class FileUtil {
    //文件上传工具类服务方法

    public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception{


        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }


        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.printf(suffix);
        if((suffix.equals(".bmp")||suffix.equals(".jpg")||suffix.equals(".jpeg")||suffix.equals(".png")||suffix.equals("gif"))){
            suffix=".jpg";

        }else {
            suffix=".mp4";
        }

        fileName=UUID.randomUUID() + suffix;

        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return  filePath+fileName;
    }

}
