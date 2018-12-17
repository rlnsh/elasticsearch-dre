package com.hikvision.dre.domain.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 11:18
 * @Description: 上传文档记录表
 */
@Entity
@Table(name = "es_dre_upload_document_record")
@EntityListeners(AuditingEntityListener.class)
public class EsDreUploadDocumentRecord extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.hikvision.dre.domain.generator.SnowflakeIdWorker")
    private Long id;

    /**
     * 文件名
     */
    @Column(name = "file_name", nullable = false, columnDefinition = "varchar(200) default ''")
    private String fileName;

    /**
     * 文件保存路径
     */
    @Column(name = "file_path", nullable = false, columnDefinition = "varchar(1000) default ''")
    private String filePath;

    /**
     * 文件大小(单位 b)
     */
    @Column(name = "file_size", nullable = false, columnDefinition = "bigint(20) default 0")
    private Long fileSize;

    /**
     * 文件类型
     */
    @Column(name = "file_type", nullable = false, columnDefinition = "varchar(20) default ''")
    private String fileType;

    /**
     * 文件发布日期（yyyy-MM-dd）
     */
    @Column(name = "publish_date", nullable = false, columnDefinition = "date default '1970-01-01'")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
