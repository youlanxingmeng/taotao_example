package com.taotao.controller;

import com.taotao.common.util.JsonUtils;
import com.taotao.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.controller
 * @date 2018/1/29
 */
@Controller
public class UploadController {
    @Value("${TAOTAO_IMAGE_URL}")
    private String TAOTAO_IMAGE_URL;


    @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE +";charset=utf-8")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile){
        try {
            //1.取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            //2.创建一个FastDFS的客户端
            FastDFSClient client = new FastDFSClient("classpath:resource/fastdfs.conf");
            String imagePath = client.uploadFile(uploadFile.getBytes(), extName);
            //拼接URL,将完整的URL存入到数据里面
            String complPath = TAOTAO_IMAGE_URL+imagePath;
            HashMap<String, Object> map = new HashMap<>();
            map.put("error",0);
            map.put("url",complPath);
            return JsonUtils.objectToJson(map);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap<String, Object> map = new HashMap<>();
            map.put("error",1);
            map.put("message","上传失败");
            return JsonUtils.objectToJson(map);
        }


    }




}
