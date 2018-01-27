package com.taotao.service;



import com.taotao.common.pojo.EasyUITreeResult;

import java.util.List;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.service
 * @date 2018/1/27
 */
public interface ItemCatService {
    public List<EasyUITreeResult> getItemCatList(Long parentId);
}
