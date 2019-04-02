package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Api(description = "测试接口", produces = "application/json")
@RestController
@RequestMapping("/test/")
public class TestController {

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "test", notes = "test")
    @PostMapping(value = "test")
    public List<String> test(@RequestParam("file") MultipartFile file) throws Exception {
        // prefix 文件名 suffix 文件格式
        // 默认是tmp格式  C:\Users\dell\AppData\Local\Temp\tmp8784723057512789016.tmp
        File savedFile = File.createTempFile("tmp", null);
        file.transferTo(savedFile);
        return getFileContext(savedFile);
    }

    public static List<String> getFileContext(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.trim().length() > 2) {
                list.add(str);
            }
        }
        return list;
    }
}
