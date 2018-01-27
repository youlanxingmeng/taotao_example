package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.service
 * @date 2018/1/26
 */
public interface ItemService {
    public EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
