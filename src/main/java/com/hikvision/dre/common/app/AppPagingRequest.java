package com.hikvision.dre.common.app;

import java.util.UUID;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:37
 * @Description: 入参基类-分页
 */
public abstract class AppPagingRequest extends AppRequest {

    private static final long serialVersionUID = -6907842080246753978L;

    protected Integer pageIndex;

    protected Integer pageSize = 10;

    protected Long from = 0L;

    protected Integer size = 10;

    protected String requestId = UUID.randomUUID().toString();

    public Integer getPageIndex() {
        return this.pageIndex == null ? (int)(this.from / (long)this.getSize()) : this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return this.pageSize != null ? this.pageSize : this.size;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getFrom() {
        return this.from == null ? (long)(this.pageIndex * this.getPageSize()) : this.from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Integer getSize() {
        return this.size == null ? this.pageSize : this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
