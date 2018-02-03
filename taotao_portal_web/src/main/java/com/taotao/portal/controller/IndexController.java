package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.portal.controller
 * @date 2018/1/30
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
