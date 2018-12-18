package com.hikvision.dre.common.app;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:40
 * @Description: 出参基类-分页
 */
public abstract class AppPagingResponse<E extends Serializable> extends BaseResponse{

    /**
     * 分页信息
     */
    protected PageProp pageProp;

    protected List<E> data;

    public PageProp getPageProp() {
        return pageProp;
    }

    public void setPageProp(PageProp pageProp) {
        this.pageProp = pageProp;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
