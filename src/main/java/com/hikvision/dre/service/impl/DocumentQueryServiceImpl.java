package com.hikvision.dre.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.bean.es.query.response.ESQueryResponseBean;
import com.hikvision.dre.bean.es.query.response.metadata.Hits;
import com.hikvision.dre.common.ESApiConstantsService;
import com.hikvision.dre.dto.doc.request.query.QueryDocListRequest;
import com.hikvision.dre.dto.doc.response.query.QueryDocListResponse;
import com.hikvision.dre.exception.ErrorCode;
import com.hikvision.dre.service.DocumentQueryService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 14:17
 * @Description: 文档检索相关实现类
 */
@Service
public class DocumentQueryServiceImpl implements DocumentQueryService {

    private static final Logger logger = LoggerFactory.getLogger(DocumentQueryServiceImpl.class);

    @Autowired private RestTemplate restTemplate;

    @Autowired private ESApiConstantsService esApiConService;

    /**
     * 根据条件查询文档列表
     * @param request
     * @return
     */
    @Override
    public QueryDocListResponse queryDocList(QueryDocListRequest request) {
        QueryDocListResponse response = new QueryDocListResponse();

        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + esApiConService.ES_URL_SEARCH_SUFFIX;
        String queryBody;
        PagingUtil.updatePageRequest(request);
        try {
            queryBody = GenerateSearchApiUtil.getBoolMustQueryDSL(request, QueryDocListRequest.class);
        } catch (IllegalAccessException e) {
            logger.error("生成ES查询语句失败：", e);
            response.setCode(ErrorCode.SELF_PROGRAMER);
            response.setMsg("生成ES查询语句失败");
            return response;
        }
        logger.info("根据条件查询文档列表-es查询入参：{}", queryBody);
        ResponseEntity<ESQueryResponseBean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, RestTemplateUtil.getRequestBody(queryBody), ESQueryResponseBean.class);

        PagingUtil.updatePageProp(response, request, responseEntity.getBody()); //更新分页信息

        List<QueryDocListResponse.DocInfo> results = new ArrayList<>();
        Hits hits = responseEntity.getBody().getHits();
        List<Hits.Hit> hitList = hits.getHits();
        for (Hits.Hit hit : hitList) {
            Map<String, Object> source = hit.get_source();
            Map<String, List<String>> highlight = hit.getHighlight();
            QueryDocListResponse.DocInfo docInfo = JSONArray.parseObject(JSONObject.toJSONString(source), QueryDocListResponse.DocInfo.class);
            docInfo.setId(hit.get_id());
            docInfo.setHighlights(highlight.get("attachment.content"));
            results.add(docInfo);
        }

        response.setResults(results);
        return response;
    }
}
