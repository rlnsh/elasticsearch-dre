package com.wdd.dre.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wdd.dre.bean.es.dictionary.ESTermsEnum;
import com.wdd.dre.bean.es.query.response.ESQueryResponseBean;
import com.wdd.dre.bean.es.query.response.metadata.Hits;
import com.wdd.dre.dto.doc.request.query.GetDocDetailRequest;
import com.wdd.dre.dto.doc.request.query.QueryDocListRequest;
import com.wdd.dre.dto.doc.response.query.GetDocDetailResponse;
import com.wdd.dre.dto.doc.response.query.QueryDocListResponse;
import com.wdd.dre.exception.ErrorCode;
import com.wdd.dre.util.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 14:17
 * @Description: 文档检索相关实现类
 */
@Service
public class DocumentQueryServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(DocumentQueryServiceImpl.class);

    @Autowired private ESQueryApiService esQueryApiService;

    /**
     * 根据条件查询文档列表
     * @param request
     * @return
     */
    public QueryDocListResponse queryDocList(QueryDocListRequest request) {
        QueryDocListResponse response = new QueryDocListResponse();

        ESQueryResponseBean esQueryResponseBean;
        try {
            esQueryResponseBean = esQueryApiService.boolMustQueryPage(request, QueryDocListRequest.class);
        } catch (IllegalAccessException e) {
            logger.error("ES查询失败：", e);
            response.setCode(ErrorCode.SELF_PROGRAMER);
            response.setMsg("ES查询失败");
            return response;
        }

        PagingUtil.updatePageProp(response, request, esQueryResponseBean); //更新分页信息

        List<QueryDocListResponse.DocInfo> results = new ArrayList<>();
        Hits hits = esQueryResponseBean.getHits();
        List<Hits.Hit> hitList = hits.getHits();
        for (Hits.Hit hit : hitList) {
            Map<String, Object> source = hit.get_source();
            Map<String, List<String>> highlight = hit.getHighlight();
            QueryDocListResponse.DocInfo docInfo = JSONArray.parseObject(JSONObject.toJSONString(source), QueryDocListResponse.DocInfo.class);
            docInfo.setId(hit.get_id());
            docInfo.setHighlights(highlight != null ? highlight.get("attachment.content") : new ArrayList<>());
            results.add(docInfo);
        }

        response.setData(results);
        return response;
    }

    /**
     * 获取单个文档详情
     * @param request
     * @return
     */
    public GetDocDetailResponse getDocDetailById(GetDocDetailRequest request) {
        GetDocDetailResponse response = new GetDocDetailResponse();
        String[] ids = {request.getId()};
        ESQueryResponseBean esQueryResponseBean = esQueryApiService.queryTerms(ids, ESTermsEnum.ID);
        Hits hits = esQueryResponseBean.getHits();
        List<Hits.Hit> hitList = hits.getHits();
        Hits.Hit hit = hitList.size() > 0 ? hitList.get(0) : new Hits.Hit();
        Map<String, Object> source = hit.get_source();
        GetDocDetailResponse.DocDetailInfo docDetailInfo = JSONArray.parseObject(JSONObject.toJSONString(source), GetDocDetailResponse.DocDetailInfo.class);
        response.setData(docDetailInfo);
        return response;
    }
}
