package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.controller
 * @date 2018/1/26
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItmeList(Integer page,Integer rows){
        EasyUIDataGridResult result = itemService.getItemList(page,rows);
        return result;
    }
    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult saveItem(TbItem tbItem,String desc){
        return itemService.saveItem(tbItem,desc);
    }

}
