package com.hikvision.dre.webserv;

import com.hikvision.dre.common.BaseController;
import com.hikvision.dre.dto.doc.request.DeleteDocByIdRequest;
import com.hikvision.dre.dto.doc.request.UpdateDocByIdRequest;
import com.hikvision.dre.dto.doc.request.upload.UploadDocumentBase64Request;
import com.hikvision.dre.dto.doc.request.upload.UploadDocumentRequest;
import com.hikvision.dre.dto.doc.response.DeleteDocByIdResponse;
import com.hikvision.dre.dto.doc.response.UpdateDocByIdResponse;
import com.hikvision.dre.dto.doc.response.upload.UploadDocumentResponse;
import com.hikvision.dre.service.DocumentService;
import com.hikvision.dre.service.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 10:43
 * @Description: 文档增删改入口
 */
@RestController
public class IDocumentService extends BaseController implements DocumentService {

    @Autowired private DocumentServiceImpl documentService;

    /**
     * 上传文档数据到ES
     * @param request
     * @return
     */
    @Override
    public UploadDocumentResponse uploadDocument(@RequestBody UploadDocumentRequest request) {
        return documentService.uploadDocument(request);
    }

    /**
     * 上传文档数据到ES-传输Base64文档流
     * @param request
     * @return
     */
    @Override
    public UploadDocumentResponse uploadDocumentBase64(@RequestBody UploadDocumentBase64Request request) {
        return documentService.uploadDocumentBase64(request);
    }

    /**
     * 根据ID更新文档信息
     * @param request
     * @return
     */
    @Override
    public UpdateDocByIdResponse updateDocById(@RequestBody UpdateDocByIdRequest request) {
        return documentService.updateDocById(request);
    }

    /**
     * 根据ID删除某个文档
     * @param request
     * @return
     */
    @Override
    public DeleteDocByIdResponse deleteDocById(@RequestBody DeleteDocByIdRequest request) {
        return documentService.deleteDocById(request);
    }
}
