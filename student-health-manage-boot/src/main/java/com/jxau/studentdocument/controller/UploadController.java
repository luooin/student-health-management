package com.jxau.studentdocument.controller;

import com.jxau.studentdocument.advice.ExceptionEnums;
import com.jxau.studentdocument.advice.MyException;
import com.jxau.studentdocument.utils.AliOSSUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Api(tags = "文件上传接口")
@RestController
@RequestMapping(value = "api/uploadFile")
/*public class UploadController {


    @PostMapping("/upload")
    public ResponseEntity<String> uploadLocal(MultipartFile file) throws IOException {
        if (Objects.isNull(file)) {
            throw new MyException(ExceptionEnums.CHOOSE_FILE);
        } else {
            String fileName = file.getOriginalFilename();
            Integer index = fileName.lastIndexOf('.');
            String suffix = fileName.substring(index, fileName.length());
            System.out.println(suffix);
            String start = "";
            if ((".png").equals(suffix)) {
                start = "data:image/png;base64,";
            }
            if ((".jpg").equals(suffix) || (".jpeg").equals(suffix)) {
                start = "data:image/jpeg;base64,";
            }
            InputStream inputStream = file.getInputStream();
            OutputStream outputStream = new ByteArrayOutputStream();
            new BASE64Encoder().encodeBuffer(inputStream, outputStream);
            String key = outputStream.toString();
            return ResponseEntity.ok(start + key);
        }

    }

}*/

public class UploadController {
//    @Autowired
//    private TenxunUtils tenxunUtils;

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("upload")
    public ResponseEntity<String> upload(MultipartFile file, HttpServletRequest request) throws IOException {
//        String fileName = tenxunUtils.ContentCOS(file, request);
        String fileName = aliOSSUtils.upload(file);

        if (!"".equals(fileName)){
            return ResponseEntity.ok(fileName);
        }
        throw new MyException(ExceptionEnums.CHOOSE_FILE);
    }
}
