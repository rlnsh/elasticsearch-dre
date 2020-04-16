//package com.wdd.dre.web;
//
//import com.wdd.dre.common.BaseController;
//import com.wdd.dre.dto.doc.request.query.QueryDocListRequest;
//import com.wdd.dre.dto.doc.response.query.QueryDocListResponse;
//import com.wdd.dre.service.DocumentQueryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Auther: wangdingding5
// * @Date: 2018/12/17 09:34
// * @Description: 文档查询相关入口
// */
//@RestController
//@RequestMapping("/document/query")
//public class DocumentQueryController extends BaseController {
//
//    @Autowired private DocumentQueryService documentQueryService;
//
//    /**
//     * 根据条件查询文档列表
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/queryDocList", method = RequestMethod.POST)
//    public QueryDocListResponse queryDocList(@RequestBody QueryDocListRequest request) {
//        QueryDocListResponse response = documentQueryService.queryDocList(request);
//        return response;
//    }
//}
