package com.wdd.dre.common.app;

import com.wdd.dre.exception.ErrorCode;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 15:29
 * @Description: 出参基类
 */
public abstract class BaseResponse implements Serializable {

    protected String code = ErrorCode.CORRECT_CODE;

    protected String msg = "success";

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
}
