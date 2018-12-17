package com.hikvision.dre.dto.doc.request.upload;

import com.hikvision.dre.common.app.AppRequest;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:36
 * @Description: 上传文档入参
 */
public class UploadDocumentRequest extends AppRequest {
    private static final long serialVersionUID = -3881458742010071180L;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
}
