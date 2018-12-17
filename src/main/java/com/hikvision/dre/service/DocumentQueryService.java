package com.hikvision.dre.service;

import com.hikvision.dre.dto.doc.request.query.QueryDocListRequest;
import com.hikvision.dre.dto.doc.response.query.QueryDocListResponse;

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
    QueryDocListResponse queryDocList(QueryDocListRequest request);
}
