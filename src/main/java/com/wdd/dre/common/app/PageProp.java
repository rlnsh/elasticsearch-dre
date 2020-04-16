package com.wdd.dre.common.app;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 15:03
 * @Description: 分页参数
 */
public class PageProp implements Serializable {

    /**
     * 从第几条开始
     */
    private long from;

    /**
     * 当前第几页
     */
    private long pageIndex;

    /**
     * 每页多少条
     */
    private long pageSize;

    /**
     * 总共多少条
     */
    private long total;

    /**
     * 总共多少页
     */
    private long pageCount;

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }
}
