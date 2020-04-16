package com.wdd.dre.service;

import com.wdd.dre.dto.doc.request.query.GetDocDetailRequest;
import com.wdd.dre.dto.doc.request.query.QueryDocListRequest;
import com.wdd.dre.dto.doc.response.query.GetDocDetailResponse;
import com.wdd.dre.dto.doc.response.query.QueryDocListResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 14:17
 * @Description: 文档检索相关
 */
public interface DocumentQueryService {

    /**
     * 根据条件查询文档列表
     * @param request
     * @return
     */
    @RequestMapping("es/dre/document/queryDocList")
    QueryDocListResponse queryDocList(@RequestBody QueryDocListRequest request);

    /**
     * 获取单个文档详情
     * @param request
     * @return
     */
    @RequestMapping("es/dre/document/getDocDetailById")
    GetDocDetailResponse getDocDetailById(@RequestBody GetDocDetailRequest request);
}
