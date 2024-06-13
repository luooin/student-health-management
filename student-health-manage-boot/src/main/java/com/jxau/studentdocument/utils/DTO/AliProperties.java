package com.jxau.studentdocument.utils.DTO;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : luoC
 * @data : 2024/2/28 14:37
 * @description :
 */
@Component
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliProperties {
    private String endpoint;		//Bucket域名
    private String accessKeyId;		//阿里云账号AccessKey
    private String accessKeySecret;	//阿里云账号AccessKey对应的秘钥
    private String bucketName;		//Bucket名称

}