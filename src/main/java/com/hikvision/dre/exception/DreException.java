package com.hikvision.dre.exception;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 09:38
 * @Description:
 */
public class DreException extends RuntimeException {

    private String errorCode = ErrorCode.SELF_PROGRAMER;

    public DreException(String errorCode) {
        this.errorCode = errorCode;
    }

    public DreException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public DreException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public DreException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public DreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
