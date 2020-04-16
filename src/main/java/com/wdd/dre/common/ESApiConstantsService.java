package com.wdd.dre.common;

import org.springframework.stereotype.Service;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 14:32
 * @Description: ESApi常量服务
 */
@Service
public class ESApiConstantsService {

    public static final String SLASH = "/";

    /**
     * DOC es_url前缀
     */
    public static final String ES_URL_DOC_PREFIX = ESApiConstants.getEsUrl() + SLASH + ESApiConstants.getIndexNameDoc() + SLASH + ESApiConstants.getIndexTypeDoc();
    /**
     * DOC es_api管道后缀
     */
    public static final String ES_URL_PIPELINE_DOC_SUFFIX = "?pipeline=" + ESApiConstants.getPipelineNameDoc();

    /**
     * es_api检索后缀
     */
    public static final String ES_URL_SEARCH_SUFFIX = "_search?pretty";
    /**
     * es_api更新后缀
     */
    public static final String ES_URL_UPDATE_SUFFIX = "_update?pretty";
}
