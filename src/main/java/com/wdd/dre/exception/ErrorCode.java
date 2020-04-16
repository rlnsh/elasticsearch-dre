/**
 * @ProjectName: CMS基线平台软件
 * @Copyright: 2010 HangZhou Hikvision System Technology Co., Ltd. All Right Reserved.
 * @address: http://www.wdd.com
 * @date: 2017年5月19日 下午3:47:41
 * @Description: 本内容仅限于杭州海康威视数字技术系统公司内部使用，禁止转发.
 */
package com.wdd.dre.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 错误吗常量,以30开头,位数为6位
 * </p>
 *
 * @author wujian3 2017年5月19日 下午3:47:41
 * @version V1.0
 */
public class ErrorCode {

	//程序错误信息
	private static final Map<String, String> ERROR_MSG_MAP = new HashMap<String, String>();
	
    public static final String SELF_PROGRAMER = "0x08800107";//程序内部错误
    public static final String FORM_ERROR = "0x0880121"; //表单提交错误
    public static final String CORRECT_CODE = "0";
    public static final String UN_KNOWN_ERROR = "0x00137001"; // 未知错误
    public static final String REST_CONN_TIMEOUT = "0x0013700A"; // 请求超时
    public static final String REST_READ_TIMEOUT = "0x0013700B"; // 读取超时
    public static final String HTTP_HOST_CONNECT_TIMEOUT = "0x0013700F";//对方服务器未启动或host错误
    public static final String ERROR_UPLOAD_FILE_BY_LOCAL = "0x00137029";//上传图片出错

    public static final String SQL_ERROE = "0x0100000D";
    public static final String PARAM_JSONARRAY = "0x0100000E";
    public static final String EXIST_ID = "0x0100000F";
    public static final String DELETE_ID = "0x01000010";
    public static final String SQL_EXIST_ID = "0x01000011";
    public static final String DELETE_KEY = "0x01000012";
    public static final String FILE_CANNOT_NULL = "0x0100001A";
    public static final String COPY_NO_FILE = "0x01000019";
    public static final String OSS_LICENSE_NOTICE = "0x0100002A";
    public static final String OSS_LICENSE_NOTICE_DELETE = "0x0100002B";
    public static final String DOWNLOAD_FILE_NULL = "0x0100002C";
    public static final String SORT_ERROR = "0x01000032";
    public static final String FILE_NO_EXIST = "0x0100001F";
    
    static {
    	ERROR_MSG_MAP.put(SELF_PROGRAMER, "程序内部错误");
    	ERROR_MSG_MAP.put(FORM_ERROR, "表单提交错误");
    	ERROR_MSG_MAP.put(UN_KNOWN_ERROR, "未知错误");
    	ERROR_MSG_MAP.put(REST_CONN_TIMEOUT, "请求超时");
    	ERROR_MSG_MAP.put(REST_READ_TIMEOUT, "读取超时");
    	ERROR_MSG_MAP.put(HTTP_HOST_CONNECT_TIMEOUT, "对方服务器未启动或host错误");
    	ERROR_MSG_MAP.put(ERROR_UPLOAD_FILE_BY_LOCAL, "上传图片出错");
    	ERROR_MSG_MAP.put(SQL_ERROE, "[SQL]失败");
    	ERROR_MSG_MAP.put(PARAM_JSONARRAY, "入参转化为JSONArray异常，请检查入参是否正确（格式：[{}]）");
    	ERROR_MSG_MAP.put(EXIST_ID, "入参中不存在[component]，请检查入参是否正确(格式：[{}])");
    	ERROR_MSG_MAP.put(DELETE_ID, "不存在该id的数据");
    	ERROR_MSG_MAP.put(DELETE_KEY, "不存在该[key]的数据");
    	ERROR_MSG_MAP.put(SQL_EXIST_ID, "库中不存在该key=value的数据");   	
    	ERROR_MSG_MAP.put(FILE_CANNOT_NULL, "[url]文件不能为空");
    	ERROR_MSG_MAP.put(COPY_NO_FILE, "[url]路径下没有文件");
    	ERROR_MSG_MAP.put(OSS_LICENSE_NOTICE, "授权许可数据有误");
    	ERROR_MSG_MAP.put(OSS_LICENSE_NOTICE_DELETE, "授权许可删除有误");
    	ERROR_MSG_MAP.put(DOWNLOAD_FILE_NULL, "下载项文件为空");
    	ERROR_MSG_MAP.put(SORT_ERROR, "排序时错误");
    	ERROR_MSG_MAP.put(FILE_NO_EXIST, "读取translate文件出错");
    }
    
    /**
     * 获取错误信息
     * @param errorCode
     * @return
     */
    public static String getErrorMsg(String errorCode) {
    	return ERROR_MSG_MAP.get(errorCode);
    }
    
}
