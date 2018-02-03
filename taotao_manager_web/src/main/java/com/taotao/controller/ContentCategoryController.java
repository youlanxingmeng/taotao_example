package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeResult;

import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContentCategory;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.controller
 * @date 2018/1/30
 */
@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeResult> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        return contentCategoryService.getContentCategoryList(parentId);
    }

    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult createContentCategory(TbContentCategory tbContentCategory){
        return contentCategoryService.createContentCategory(tbContentCategory);
    }
    @RequestMapping("/content/category/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(TbContentCategory tbContentCategory){
        return contentCategoryService.updateContentCategory(tbContentCategory);
    }
}
