package com.hikvision.dre.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:56
 * @Description: ES-API常量
 */
@Component
public class ESApiConstants {

    public static String ES_URL; //es服务地址

    public static String USER_NAME; //es用户名

    public static String PASSWORD; //es密码

    public static String PIPELINE_NAME_DOC; //管道名称

    public static String INDEX_NAME_DOC; //索引名称

    public static String INDEX_TYPE_DOC; //索引类型

    @Value("${es.url}")
    public void setEsUrl(String esUrl) {
        ES_URL = esUrl;
    }

    @Value("${es.userName}")
    public void setUserName(String userName) {
        USER_NAME = userName;
    }

    @Value("${es.password}")
    public void setPASSWORD(String PASSWORD) {
        ESApiConstants.PASSWORD = PASSWORD;
    }

    @Value("${es.doc.pipelineName}")
    public void setPipelineNameDoc(String pipelineNameDoc) {
        PIPELINE_NAME_DOC = pipelineNameDoc;
    }

    @Value("${es.doc.indexName}")
    public void setIndexNameDoc(String indexNameDoc) {
        INDEX_NAME_DOC = indexNameDoc;
    }

    @Value("${es.doc.indexType}")
    public void setIndexTypeDoc(String indexTypeDoc) {
        INDEX_TYPE_DOC = indexTypeDoc;
    }

}
