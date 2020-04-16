package com.wdd.dre.dto.doc.request;

import com.wdd.dre.common.app.AppRequest;

import javax.validation.constraints.NotNull;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 19:52
 * @Description: 根据ID删除某个文档入参
 */
public class DeleteDocByIdRequest extends AppRequest {

    @NotNull(message = "文档id不能为空！")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
