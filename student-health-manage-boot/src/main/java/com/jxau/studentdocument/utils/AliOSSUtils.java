package com.jxau.studentdocument.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.jxau.studentdocument.utils.DTO.AliProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author : luoC
 * @data : 2024/2/28 14:39
 * @description :
 */
@Component
public class AliOSSUtils {
    /**
     * 注入AliProperties
     */
    @Autowired
    private AliProperties aliProperties;

    /**
     * 实现上传图片到OSS
     */
    /*public String upload(MultipartFile file) throws IOException {
        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(aliProperties.getEndpoint(), aliProperties.getAccessKeyId(), aliProperties.getAccessKeySecret());
        ossClient.putObject(aliProperties.getBucketName(), fileName, inputStream);

        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = "luocong/" + format + "/";

        //文件访问路径
        String url = aliProperties.getEndpoint().split("//")[0] + "//" + aliProperties.getBucketName() + "." + aliProperties.getEndpoint().split("//")[1] + "/" + dir +fileName;
        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }*/

    public String upload(MultipartFile file){
        /*获取文件名*/
        String fileName = file.getOriginalFilename();
        /*获取文件后缀名*/
        String[] split = fileName.split("\\.");
        /*后缀名*/
        String houzui = "."+split[split.length - 1];
        if(file.getSize() > 100*1024*1024){
            throw new RuntimeException("文件大于100M");
        }

        // 填写Host地址，格式为https://bucketname.endpoint。
        String host = "https://"+aliProperties.getBucketName()+"."+aliProperties.getEndpoint();

        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = "luocong/" + format + "/";

        try {

            OSS ossClient = new OSSClientBuilder().build(aliProperties.getEndpoint(), aliProperties.getAccessKeyId(), aliProperties.getAccessKeySecret());

            InputStream inputStream = file.getInputStream();

            String newName = UUID.randomUUID().toString().replace("-","");

            fileName = dir + newName + houzui;

            ossClient.putObject(aliProperties.getBucketName(),fileName , inputStream);
            ossClient.shutdown();

            return host+"/"+fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
