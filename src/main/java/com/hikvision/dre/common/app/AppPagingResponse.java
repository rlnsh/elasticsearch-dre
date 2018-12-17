package com.hikvision.dre.common.app;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:40
 * @Description: 出参基类-分页
 */
public abstract class AppPagingResponse<E extends Serializable> extends AppResponse<PageProp> {

    protected List<E> results;

    public List<E> getResults() {
        return results;
    }

    public void setResults(List<E> results) {
        this.results = results;
    }
}
