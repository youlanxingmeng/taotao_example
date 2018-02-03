package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.util.IDUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //分页查询 pagehelper
        //1.设置分页
        PageHelper.startPage(page,rows);//仅跟着的第一个查询才会被分页
        //查询所有
        List<TbItem> tbItems = tbItemMapper.selectByExample(null);

        //构建分页的对象 里面包括了总记录数
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        long total = info.getTotal();
        //创建EasyUIDataGridResult 对象  封装属性（total rows）
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(total);
        result.setRows(info.getList());
        return result;
    }

    @Override
    public TaotaoResult saveItem(TbItem item, String desc) {
        //1.生成商品id
        long itemId = IDUtils.genItemId();
        //2.补全TbItem对象的属性
        item.setId(itemId);
        //商品状态
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        tbItemMapper.insertSelective(item);
        //插入商品的描述表,构建一个对象
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(itemId);
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getCreated());
        tbItemDescMapper.insertSelective(itemDesc);
        return TaotaoResult.ok();
    }
}
