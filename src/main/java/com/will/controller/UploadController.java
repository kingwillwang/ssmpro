package com.will.controller;

import com.will.common.Result;
import com.will.common.ResultGenerator;
import com.will.utils.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: WillWang
 * @Description:
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Value("${baseDir}")
    private String baseDir;

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public Result imageUpload(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
                              @RequestParam(value = "moduleType", required = false) String moduleType) {
        if (!file.isEmpty()) {
            String nowDate = DateUtil.formatDate(new Date(), "yyyyMMdd");
            String fileRealName = file.getOriginalFilename();                      //获得原始文件名;
            int pointIndex = fileRealName.lastIndexOf(".");                  //点号的位置
            String fileSuffix = fileRealName.substring(pointIndex + 1).toLowerCase(); //截取文件后缀
            String savedFileName = UUID.randomUUID().toString().replace("-", "").concat(".").concat(fileSuffix);//文件存取名
            String secondDir = "/" + moduleType + "/" + nowDate;
            String fileDir = baseDir + secondDir;
            String imageUrl = "/uploadImg" + secondDir + "/" + savedFileName;
            try {
                FileUtils.writeByteArrayToFile(new File(fileDir, savedFileName), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return ResultGenerator.genFailResult("操作失败！");
            }
            return ResultGenerator.genSuccessResult(imageUrl);
        } else {
            return ResultGenerator.genFailResult("文件不存在！");
        }
    }
}