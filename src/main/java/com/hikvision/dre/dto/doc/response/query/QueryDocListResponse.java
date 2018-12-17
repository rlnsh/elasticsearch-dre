package com.hikvision.dre.dto.doc.response.query;

import com.hikvision.dre.common.app.AppPagingResponse;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 14:48
 * @Description: 根据条件检索文档出参
 */
public class QueryDocListResponse extends AppPagingResponse {

    private static final long serialVersionUID = 8788617978642223362L;

    public static class DocInfo implements Serializable {

        private static final long serialVersionUID = -479790102842797627L;

        /**
         * 文档在ES中存放id
         */
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
         * 文档类型
         */
        private String docType;

        /**
         * 突出内容
         */
        private List<String> highlights;

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

        public String getDocType() {
            return docType;
        }

        public void setDocType(String docType) {
            this.docType = docType;
        }

        public List<String> getHighlights() {
            return highlights;
        }

        public void setHighlights(List<String> highlights) {
            this.highlights = highlights;
        }
    }

}
