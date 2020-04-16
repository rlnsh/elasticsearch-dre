package com.wdd.dre.common.app;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:40
 * @Description: 出参基类
 */
public abstract class AppResponse<T extends Serializable> extends BaseResponse {

    protected T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
