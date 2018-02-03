package com.taotao.service.impl;


import com.taotao.common.pojo.EasyUITreeResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.service.impl
 * @date 2018/1/30
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper mapper;
    @Override
    public List<EasyUITreeResult> getContentCategoryList(Long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<TbContentCategory> contentCategoryList = mapper.selectByExample(example);
        List<EasyUITreeResult> easyUITreeResults = new ArrayList<>();
        for (TbContentCategory tbContentCategory : contentCategoryList) {
            EasyUITreeResult easyUITreeResult = new EasyUITreeResult();
            easyUITreeResult.setId(tbContentCategory.getId());
            easyUITreeResult.setText(tbContentCategory.getName());
            easyUITreeResult.setState(tbContentCategory.getIsParent()?"closed":"open");
            easyUITreeResults.add(easyUITreeResult);
        }
        return easyUITreeResults;
    }

    @Override
    public TaotaoResult createContentCategory(TbContentCategory tbContentCategory) {
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setIsParent(false);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setUpdated(new Date());
        //判断节点的父亲本身节点
        TbContentCategory parent = mapper.selectByPrimaryKey(tbContentCategory.getParentId());
        if (!parent.getIsParent()){
            parent.setIsParent(true);
        }
        mapper.updateByPrimaryKey(parent);
        mapper.insertSelective(tbContentCategory);
        return TaotaoResult.ok(tbContentCategory);
    }

    @Override
    public TaotaoResult updateContentCategory(TbContentCategory tbContentCategory) {
        mapper.updateByPrimaryKeySelective(tbContentCategory);
        return TaotaoResult.ok(tbContentCategory);
    }
}
