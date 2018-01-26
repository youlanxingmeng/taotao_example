package com.taotao.common.pojo;

import java.util.List;

/**
 * @author jianghao
 * @version 1.0
 * @description com.taotao.common.pojo
 * @date 2018/1/26
 */
public class EasyUIDataGridResult {
    private Long total;
    private List rows;

    public Long getTotal() {
        return total;
    }

    public List getRows() {
        return rows;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
