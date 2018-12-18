package com.hikvision.dre.common.app;


import com.hikvision.dre.exception.ErrorCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 09:34
 * @Description:
 */
public class WsResult<T extends Serializable> implements Serializable{

	private static final long serialVersionUID = 6067293224506425116L;

	private String errorCode = ErrorCode.CORRECT_CODE;
	
	private String errorMessage;
	
	private T data;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static WsResult create(String errorCode){
		WsResult wr = new WsResult();
		wr.setErrorCode(errorCode);
		wr.setErrorMessage("成功");
		return wr;
	}

	public static WsResult create(String errorCode,String msg){
		WsResult wr = new WsResult();
		wr.setErrorCode(errorCode);
		wr.setErrorMessage(msg);
		return wr;
	}
	
	public static WsResult create(){
		return create(ErrorCode.CORRECT_CODE);
	}

}
