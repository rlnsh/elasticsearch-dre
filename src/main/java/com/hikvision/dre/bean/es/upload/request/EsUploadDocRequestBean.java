package com.hikvision.dre.bean.es.upload.request;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 13:50
 * @Description:
 */
public class EsUploadDocRequestBean implements Serializable {

    private static final long serialVersionUID = -8751492839539395807L;

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
     * 文件Base64
     */
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
