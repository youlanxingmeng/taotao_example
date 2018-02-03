package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.service
 * @date 2018/1/26
 */
public interface ItemService {
    public EasyUIDataGridResult getItemList(Integer page,Integer rows);
    public TaotaoResult saveItem(TbItem item,String desc);

}
