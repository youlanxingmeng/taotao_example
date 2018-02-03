package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContentCategory;

import java.util.List;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.service
 * @date 2018/1/30
 */
public interface ContentCategoryService {
    public List<EasyUITreeResult> getContentCategoryList(Long parentId);

    TaotaoResult createContentCategory(TbContentCategory tbContentCategory);

    TaotaoResult updateContentCategory(TbContentCategory tbContentCategory);
}
