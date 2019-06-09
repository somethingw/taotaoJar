package com.week.pojo;

import java.util.List;

/**
 * @author week
 * @Title: EUDataGridResult
 * @ProjectName taotaoJar
 * @Description: TODO
 * @date 2019/5/2714:22
 */
public class EUDataGridResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
