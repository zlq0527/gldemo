package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.config.COSUploadUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    //上传头像的方法
    @PostMapping
    public R test(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String url= new COSUploadUtil().upLoadFile2COS(file.getSize(), file.getOriginalFilename(), file);
        return R.ok().data("url",url);
    }
}
