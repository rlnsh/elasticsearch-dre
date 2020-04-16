package com.wdd.dre.dto.doc.request.query;

import com.wdd.dre.common.app.AppPagingRequest;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 14:43
 * @Description: 根据条件检索文档入参
 */
public class QueryDocListRequest extends AppPagingRequest {

    private static final long serialVersionUID = 216266623834454033L;
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
     * 文档类型
     */
    private String docType;

    /**
     * 文档内容
     */
    private String content;

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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
