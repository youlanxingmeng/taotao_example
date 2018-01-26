package com.taotao.controller;

import com.taotao.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.controller
 * @date 2018/1/25
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/getNow")
    @ResponseBody
    public String getNow(){
        System.out.println("进入方法了");
        return testService.getNow();
    }
    @RequestMapping("/demo")
    public String demo(){
        System.out.println("进入方法了");
        return null;
    }
}
