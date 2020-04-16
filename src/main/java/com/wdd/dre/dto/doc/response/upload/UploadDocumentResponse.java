package com.wdd.dre.dto.doc.response.upload;

import com.wdd.dre.common.app.AppResponse;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:50
 * @Description: 上传文档出参
 */
public class UploadDocumentResponse extends AppResponse {
    private static final long serialVersionUID = -4201167569298545660L;

    private String result = "";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
