package com.hikvision.dre.common.app;

import com.hikvision.dre.exception.ErrorCode;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:40
 * @Description: 出参基类
 */
public abstract class AppResponse<T extends Serializable> implements Serializable {

    protected String code = ErrorCode.CORRECT_CODE;

    protected String msg = "success";

    protected T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
