//package com.wdd.dre.web;
//
//import com.wdd.dre.common.BaseController;
//import com.wdd.dre.dto.doc.request.DeleteDocByIdRequest;
//import com.wdd.dre.dto.doc.request.UpdateDocByIdRequest;
//import com.wdd.dre.dto.doc.request.upload.UploadDocumentRequest;
//import com.wdd.dre.dto.doc.response.DeleteDocByIdResponse;
//import com.wdd.dre.dto.doc.response.UpdateDocByIdResponse;
//import com.wdd.dre.dto.doc.response.upload.UploadDocumentResponse;
//import com.wdd.dre.service.DocumentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Auther: wangdingding5
// * @Date: 2018/12/17 09:34
// * @Description: 文档增删改相关入口
// */
//@RestController
//@RequestMapping("/document/write")
//public class DocumentWriteController extends BaseController {
//
//    @Autowired private DocumentService documentService;
//
//    /**
//     * 上传文档数据到ES
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/uploadDocument", method = RequestMethod.POST)
//    public UploadDocumentResponse uploadDocument(@RequestBody UploadDocumentRequest request) {
//        UploadDocumentResponse response = documentService.uploadDocument(request);
//        return response;
//    }
//
//    /**
//     * 根据ID更新文档信息
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/updateDocById", method = RequestMethod.POST)
//    public UpdateDocByIdResponse updateDocById(@RequestBody UpdateDocByIdRequest request) {
//        UpdateDocByIdResponse response = documentService.updateDocById(request);
//        return response;
//    }
//
//    /**
//     * 根据ID删除某个文档
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/deleteDocById", method = RequestMethod.POST)
//    public DeleteDocByIdResponse deleteDocById(@RequestBody DeleteDocByIdRequest request) {
//        DeleteDocByIdResponse response = documentService.deleteDocById(request);
//        return response;
//    }
//}
