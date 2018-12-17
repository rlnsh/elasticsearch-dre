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
public class WsResult implements Serializable{

	private static final long serialVersionUID = 6067293224506425116L;

	private String errorCode = ErrorCode.CORRECT_CODE;
	
	private String errorMessage;
	
	private Object data;
	
	private List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public List<Map<String, Object>> getResults() {
		return results;
	}

	public void setResults(List<Map<String, Object>> results) {
		this.results = results;
	}

	public void addData(Map<String,Object> data){
		results.add(data);
	}
	public void addData(String key,Object value){
		if(null==data){
			data = new HashMap<String, Object>();
		}
		if(data instanceof Map){
			Map<String,Object> m = (Map)data;
			m.put(key, value);
		}		
	}
	
	@SuppressWarnings({"all"})
	public Object getDataValue(String key){
		if(null!=data && data instanceof Map){
			Map<String,Object> m = (Map)data;
			return m.get(key);
		}
		return null;
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public void putData(Map<String,Object> in){
		if(null==data){
			data = new HashMap<String, Object>();
		}
		if(data instanceof Map){
			Map<String,Object> m = (Map)data;
			m.putAll(in);
		}
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

	public List<Object> getListDataWithKey(String key){
		List<Object> list = new ArrayList<Object>();
		for(Map<String,Object> row : results){
			list.add(row.get(key));
		}
		return list;
	}

}
