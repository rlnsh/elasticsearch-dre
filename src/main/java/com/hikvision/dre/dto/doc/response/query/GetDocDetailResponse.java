package com.hikvision.dre.dto.doc.response.query;

import com.hikvision.dre.common.app.AppResponse;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 13:48
 * @Description: 获取单个文档详情出参
 */
public class GetDocDetailResponse extends AppResponse {

    private static final long serialVersionUID = 848674799329024478L;

    public static class DocDetailInfo implements Serializable {

        private static final long serialVersionUID = 177280150026279505L;
        /**
         * 文档在ES中存放id
         */
        private String id = "";

        /**
         * 标题
         */
        private String title = "";

        /**
         * 作者
         */
        private String author = "";

        /**
         * 摘要
         */
        private String summary = "";

        /**
         * 文件发布日期（yyyy-MM-dd）
         */
        private String publishDate = "";

        /**
         * 文档类型
         */
        private String docType = "";

        /**
         * 自动读取到的文档信息
         */
        private Attachment attachment;

        /**
         * ES-Attachment自动读取到的文档信息
         */
        public static class Attachment implements Serializable {

            private static final long serialVersionUID = 5747397728061192095L;
            /**
             * 文档类型
             */
            private String content_type = "";

            /**
             * 语言
             */
            private String language = "";

            /**
             * 文档标题
             */
            private String title = "";

            /**
             * 文档内容
             */
            private String content = "";

            /**
             * 内容长度
             */
            private Long content_length = 0L;

            public String getContent_type() {
                return content_type;
            }

            public void setContent_type(String content_type) {
                this.content_type = content_type;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Long getContent_length() {
                return content_length;
            }

            public void setContent_length(Long content_length) {
                this.content_length = content_length;
            }
        }

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

        public Attachment getAttachment() {
            return attachment;
        }

        public void setAttachment(Attachment attachment) {
            this.attachment = attachment;
        }
    }

}
