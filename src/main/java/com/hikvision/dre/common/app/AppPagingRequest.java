package com.hikvision.dre.common.app;

import java.util.UUID;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:37
 * @Description: 入参基类-分页
 */
public abstract class AppPagingRequest extends AppRequest {

    private static final long serialVersionUID = -6907842080246753978L;

    protected long pageIndex = 0;

    protected long pageSize = 10L;

    protected long from = 0L;

    protected long size = 10L;

    public long getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getFrom() {
        return this.pageIndex * this.getPageSize();
    }
    public void setFrom(long from) {
        this.from = from;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
