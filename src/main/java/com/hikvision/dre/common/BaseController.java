package com.hikvision.dre.common;

import com.hikvision.dre.common.app.WsResult;
import com.hikvision.dre.exception.DreException;
import com.hikvision.dre.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 09:34
 * @Description:
 */
public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler
	@ResponseBody
	public WsResult exceptionCatch(Throwable e){
		if(DreException.class.isAssignableFrom(e.getClass())){
			logger.error("发生自定义异常：", e);
			return WsResult.create(ErrorCode.SELF_PROGRAMER, e.getMessage());
		} else if (SQLException.class.isAssignableFrom(e.getClass())) {
			logger.error("发生SQL异常：", e);
			return WsResult.create(ErrorCode.SQL_ERROE,  ErrorCode.getErrorMsg(ErrorCode.SQL_ERROE));
		}else{
			logger.error("程序内部错误：", e);
			return WsResult.create(ErrorCode.SELF_PROGRAMER, "程序内部错误！");
		}

	}
}
