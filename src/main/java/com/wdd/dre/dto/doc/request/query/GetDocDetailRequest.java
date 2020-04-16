package com.wdd.dre.dto.doc.request.query;

import com.wdd.dre.common.app.AppRequest;

import javax.validation.constraints.NotNull;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 13:54
 * @Description: 获取单个文档详情入参
 */
public class GetDocDetailRequest extends AppRequest {

    /**
     * 文档id
     */
    @NotNull(message = "文档id不能为空！")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
