package com.wdd.dre.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:56
 * @Description: ES-API常量
 */
@Component
public class ESApiConstants {

    private static String ES_URL; //es服务地址

    private static String USER_NAME; //es用户名

    private static String PASSWORD; //es密码

    private static String PIPELINE_NAME_DOC; //管道名称

    private static String INDEX_NAME_DOC; //索引名称

    private static String INDEX_TYPE_DOC; //索引类型

    @Value("${es.url}")
    private void setEsUrl(String esUrl) {
        ES_URL = esUrl;
    }

    @Value("${es.userName}")
    private void setUserName(String userName) {
        USER_NAME = userName;
    }

    @Value("${es.password}")
    private void setPASSWORD(String PASSWORD) {
        ESApiConstants.PASSWORD = PASSWORD;
    }

    @Value("${es.doc.pipelineName}")
    private void setPipelineNameDoc(String pipelineNameDoc) {
        PIPELINE_NAME_DOC = pipelineNameDoc;
    }

    @Value("${es.doc.indexName}")
    private void setIndexNameDoc(String indexNameDoc) {
        INDEX_NAME_DOC = indexNameDoc;
    }

    @Value("${es.doc.indexType}")
    private void setIndexTypeDoc(String indexTypeDoc) {
        INDEX_TYPE_DOC = indexTypeDoc;
    }

    public static String getEsUrl() {
        return ES_URL;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getPipelineNameDoc() {
        return PIPELINE_NAME_DOC;
    }

    public static String getIndexNameDoc() {
        return INDEX_NAME_DOC;
    }

    public static String getIndexTypeDoc() {
        return INDEX_TYPE_DOC;
    }
}
