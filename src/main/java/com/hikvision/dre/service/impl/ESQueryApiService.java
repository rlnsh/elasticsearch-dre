package com.hikvision.dre.service.impl;

import com.hikvision.dre.bean.es.dictionary.ESTermsEnum;
import com.hikvision.dre.bean.es.query.response.ESQueryResponseBean;
import com.hikvision.dre.common.ESApiConstantsService;
import com.hikvision.dre.common.app.AppPagingRequest;
import com.hikvision.dre.util.GenerateSearchApiUtil;
import com.hikvision.dre.util.PagingUtil;
import com.hikvision.dre.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 14:14
 * @Description: ES查询API
 */
@Service
public class ESQueryApiService {

    private static final Logger logger = LoggerFactory.getLogger(ESQueryApiService.class);

    @Autowired private RestTemplate restTemplate;

    @Autowired private ESApiConstantsService esApiConService;

    /**
     * 多条件分页查询ES
     * @param request
     * @param c 入参类型
     * @return
     * @throws IllegalAccessException
     */
    public ESQueryResponseBean boolMustQueryPage(AppPagingRequest request, Class c) throws IllegalAccessException {
        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + esApiConService.ES_URL_SEARCH_SUFFIX;
        PagingUtil.updatePageRequest(request);
        String queryBody = GenerateSearchApiUtil.getBoolMustQueryDSL(request, c);
        return queryES(url, HttpMethod.POST, queryBody);
    }

    /**
     * 根据ES系统参数查询
     * @param values
     * @param esTermsEnum
     * @return
     */
    public ESQueryResponseBean queryTerms(String[] values, ESTermsEnum esTermsEnum) {
        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + esApiConService.ES_URL_SEARCH_SUFFIX;
        String queryBody = GenerateSearchApiUtil.genQueryTermsDSL(values, esTermsEnum);
        return queryES(url, HttpMethod.POST, queryBody);
    }

    /**
     * ES检索
     * @param url
     * @param httpMethod
     * @param queryBody
     * @return
     */
    public ESQueryResponseBean queryES(String url, HttpMethod httpMethod, String queryBody) {
        logger.info("ES-检索body:{}", queryBody);
        ResponseEntity<ESQueryResponseBean> responseEntity = restTemplate.exchange(url, httpMethod, RestTemplateUtil.getRequestBody(queryBody), ESQueryResponseBean.class);
        return responseEntity.getBody();
    }
}
