package com.jk.controller.upload;

import com.aliyun.oss.OSSClient;
import com.jk.utils.AliyunOSSClientUtil;
import com.jk.utils.OSSClientConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.jk.utils.OSSClientConstants.BACKET_NAME;

@Controller
@RequestMapping("upload")
public class UploadController {

    /*@RequestMapping("upImg")
    @ResponseBody
    public String upImg(MultipartFile artImg) throws Exception{


        OssConfig o = new OssConfig();
        String name = o.uploadImg2Oss(artImg);
        String imgUrl = o.getImgUrl(name);
//        String imgUrl = "https://three-group.oss-cn-beijing.aliyuncs.com/three_project_img/"+name;
        System.out.println("imgUrl="+imgUrl);
        //初始化OSSClient
        OSSClient ossClient=AliyunOSSClientUtil.getOSSClient();
//		Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);

//		System.out.println(expiration.toString()+"+expiration");
       // AliyunOSSClientUtil.uploadObject2OSS(ossClient, file2, BACKET_NAME, OSSClientConstants.FOLDER);
*//*
        String url = "https://lvdelong.oss-cn-beijing.aliyuncs.com/members-img/"+onlyFileName;
*//*
        //Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//        String url = ossClient.generatePresignedUrl(BACKET_NAME, onlyFileName, expiration).toString();
//        System.out.println("url="+url);
        return imgUrl;

    }*/


    @RequestMapping("upImg")
    @ResponseBody
    public String upImg(MultipartFile artImg, HttpServletRequest req) throws Exception{
        //获取原文件名称
        String fileName = artImg.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String folderPath = req.getSession().getServletContext().getRealPath("/")+
                "upload/";
        File file = new File(folderPath);
        //该目录是否已经存在
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(artImg.getBytes());
        fos.flush();
        fos.close();
        System.out.println(file);

        //得到真正的路径
        File file2 = new File(file+"\\"+onlyFileName);
System.out.println(file2+"--------------");
        //初始化OSSClient
        OSSClient ossClient= AliyunOSSClientUtil.getOSSClient();
        AliyunOSSClientUtil.uploadObject2OSS(ossClient, file2, OSSClientConstants.BACKET_NAME, OSSClientConstants.FOLDER);
        String url = "https://three-group.oss-cn-beijing.aliyuncs.com/three_project_img/"+onlyFileName;
        return url;

    }





}
