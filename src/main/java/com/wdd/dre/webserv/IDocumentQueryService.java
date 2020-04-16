package com.wdd.dre.webserv;

import com.wdd.dre.common.BaseController;
import com.wdd.dre.dto.doc.request.query.GetDocDetailRequest;
import com.wdd.dre.dto.doc.request.query.QueryDocListRequest;
import com.wdd.dre.dto.doc.response.query.GetDocDetailResponse;
import com.wdd.dre.dto.doc.response.query.QueryDocListResponse;
import com.wdd.dre.service.DocumentQueryService;
import com.wdd.dre.service.impl.DocumentQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 10:46
 * @Description: 文档检索相关入口
 */
@RestController
public class IDocumentQueryService extends BaseController implements DocumentQueryService {

    @Autowired private DocumentQueryServiceImpl documentQueryService;

    /**
     * 根据条件查询文档列表
     * @param request
     * @return
     */
    @Override
    public QueryDocListResponse queryDocList(@RequestBody QueryDocListRequest request) {
        return documentQueryService.queryDocList(request);
    }

    /**
     * 获取单个文档详情
     * @param request
     * @return
     */
    @Override
    public GetDocDetailResponse getDocDetailById(@RequestBody GetDocDetailRequest request) {
        return documentQueryService.getDocDetailById(request);
    }
}
