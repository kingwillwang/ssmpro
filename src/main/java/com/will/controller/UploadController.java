package com.will.controller;

import com.will.common.Result;
import com.will.common.ResultGenerator;
import com.will.utils.DateUtil;
import com.will.utils.StringUtil;
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

/**
 * @Author: WillWang
 * @Description:
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Value("${baseDir}")
    private String baseDir;

    /**
     * 图片上传
     *
     * @param file    文件对象
     * @param module  模块
     * @param objName 对象名称
     * @param objType 对象类型
     * @return
     */

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public Result imageUpload(@RequestParam(value = "file") CommonsMultipartFile file,
                              @RequestParam(value = "module") String module,
                              @RequestParam(value = "objName") String objName,
                              @RequestParam(value = "objType") String objType) {
        if (!file.isEmpty()) {
            String nowDate = DateUtil.formatDate(new Date(), "yyyyMMdd");
            String nowTime = DateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
            String fileRealName = file.getOriginalFilename();                      //获得原始文件名;
            int pointIndex = fileRealName.lastIndexOf(".");                  //点号的位置
            String fileSuffix = fileRealName.substring(pointIndex + 1).toLowerCase(); //截取文件后缀
            String savedFileName = nowTime.concat(".").concat(fileSuffix);//文件存取名
            String secondDir = "/" + module + "/" + objName + "/" + objType + "/" + nowDate;
            if (StringUtil.isEmpty(objName)) {
                secondDir = "/" + module + "/" + objType + "/" + nowDate;
            }
            if (StringUtil.isEmpty(objType)) {
                secondDir = "/" + module + "/" + objName + "/" + nowDate;
            }
            if (StringUtil.isEmpty(objName) && StringUtil.isEmpty(objType)) {
                secondDir = "/" + module + "/" + nowDate;
            }
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
            return ResultGenerator.genBadResult("文件不存在！");
        }
    }
}