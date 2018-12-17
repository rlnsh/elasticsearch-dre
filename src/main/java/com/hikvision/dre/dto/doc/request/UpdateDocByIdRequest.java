package com.hikvision.dre.dto.doc.request;

import com.hikvision.dre.common.app.AppRequest;

import javax.validation.constraints.NotNull;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 19:45
 * @Description: 根据ID更新文档信息入参
 */
public class UpdateDocByIdRequest extends AppRequest {

    @NotNull(message = "文档id不能为空！")
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 文件发布日期（yyyy-MM-dd）
     */
    private String publishDate;

    /**
     * 文档内容
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
