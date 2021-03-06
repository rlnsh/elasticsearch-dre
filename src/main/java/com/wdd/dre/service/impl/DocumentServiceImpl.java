package com.wdd.dre.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wdd.dre.bean.es.upload.request.EsUploadDocRequestBean;
import com.wdd.dre.common.ESApiConstantsService;
import com.wdd.dre.dao.EsDreUploadDocumentRecordDao;
import com.wdd.dre.domain.entity.EsDreUploadDocumentRecord;
import com.wdd.dre.domain.repository.EsDreUploadDocumentRecordRepository;
import com.wdd.dre.dto.doc.request.DeleteDocByIdRequest;
import com.wdd.dre.dto.doc.request.UpdateDocByIdRequest;
import com.wdd.dre.dto.doc.request.upload.UploadDocumentBase64Request;
import com.wdd.dre.dto.doc.request.upload.UploadDocumentRequest;
import com.wdd.dre.dto.doc.response.DeleteDocByIdResponse;
import com.wdd.dre.dto.doc.response.UpdateDocByIdResponse;
import com.wdd.dre.dto.doc.response.upload.UploadDocumentResponse;
import com.wdd.dre.exception.ErrorCode;
import com.wdd.dre.util.DateUtils;
import com.wdd.dre.util.FileUtil;
import com.wdd.dre.util.GenerateUpdateApiUtil;
import com.wdd.dre.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Date;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:46
 * @Description: 文档增删改服务实现类
 */
@Service
public class DocumentServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired private ESApiConstantsService esApiConService;

    @Autowired private EsDreUploadDocumentRecordDao uploadDocumentRecordDao;

    @Autowired private EsDreUploadDocumentRecordRepository uploadDocRepository;

    /**
     * 上传文档数据到ES
     * @param request
     * @return
     */
    public UploadDocumentResponse uploadDocument(UploadDocumentRequest request) {
        UploadDocumentResponse response = new UploadDocumentResponse();

        String filePath = request.getFilePath();

        UploadDocumentBase64Request base64Request = new UploadDocumentBase64Request();
        BeanUtils.copyProperties(request, base64Request);
        try {
            File file = FileUtil.getFile(filePath);
            String data = FileUtil.encodeBase64File(file);
            base64Request.setData(data);
            base64Request.setFileSize(file.length());
        } catch (Exception e) {
            logger.error("文件Base64编码错误", e);
            response.setCode(ErrorCode.SELF_PROGRAMER);
            response.setMsg("文件Base64编码错误！");
            return response;
        }

        return uploadDocumentBase64(base64Request);
    }

    /**
     * 上传文档数据到ES-传输Base64文档流
     * @param request
     * @return
     */
    public UploadDocumentResponse uploadDocumentBase64(UploadDocumentBase64Request request) {
        UploadDocumentResponse response = new UploadDocumentResponse();

        String data = request.getData();
        String filePath = request.getFilePath() != null ? request.getFilePath() : "";
        Date publishDate = request.getPublishDate() != null ? DateUtils.parse(request.getPublishDate(), DateUtils.PATTERN_DAY) : new Date();

        EsDreUploadDocumentRecord  uploadDocRecord = new EsDreUploadDocumentRecord();
        uploadDocRecord.setFileName(request.getFileName());
        uploadDocRecord.setFileType(request.getDocType());
        uploadDocRecord.setPublishDate(publishDate);
        uploadDocRecord.setFilePath(filePath);
        uploadDocRecord.setFileSize(request.getFileSize());

        EsUploadDocRequestBean esUploadDocRequestBean = new EsUploadDocRequestBean();
        BeanUtils.copyProperties(request, esUploadDocRequestBean);
        esUploadDocRequestBean.setData(data);
        long id = uploadDocumentRecordDao.save(uploadDocRecord);

        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + id + esApiConService.ES_URL_PIPELINE_DOC_SUFFIX;

        logger.info("上传文档到ES-params:{}", JSONObject.toJSONString(esUploadDocRequestBean));
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, RestTemplateUtil.getRequestBody(esUploadDocRequestBean), String.class);
        response.setResult(result.getBody());
        return response;
    }

    /**
     * 根据ID更新文档信息
     * @param request
     * @return
     */
    public UpdateDocByIdResponse updateDocById(UpdateDocByIdRequest request) {
        UpdateDocByIdResponse response = new UpdateDocByIdResponse();
        if (request.getId() == null) {
            response.setCode(ErrorCode.FORM_ERROR);
            response.setMsg("文档id不能为空!");
        }

        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + request.getId() + esApiConService.SLASH + esApiConService.ES_URL_UPDATE_SUFFIX;
        String updateBody;
        try {
            updateBody = GenerateUpdateApiUtil.getScriptedUpdates(request, UpdateDocByIdRequest.class);
        } catch (IllegalAccessException e) {
            logger.error("生成ES更新语句失败：", e);
            response.setCode(ErrorCode.SELF_PROGRAMER);
            response.setMsg("生成ES更新语句失败");
            return response;
        }
        logger.info("根据ID更新文档信息-es更新入参：{}", updateBody);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, RestTemplateUtil.getRequestBody(updateBody), String.class);
        response.setData(responseEntity.getBody());
        return response;
    }

    /**
     * 根据ID删除某个文档
     * @param request
     * @return
     */
    public DeleteDocByIdResponse deleteDocById(DeleteDocByIdRequest request) {
        DeleteDocByIdResponse response = new DeleteDocByIdResponse();
        String id = request.getId();
        if (id == null) {
            response.setCode(ErrorCode.FORM_ERROR);
            response.setMsg("文档id不能为空!");
        }
        EsDreUploadDocumentRecord record = uploadDocRepository.findByIdAndStatus(Long.valueOf(id), 1);
        if (record == null) {
            response.setCode(ErrorCode.FORM_ERROR);
            response.setMsg("不存在此文档！");
            return response;
        }
        record.setStatus(0);
        uploadDocumentRecordDao.save(record);

        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + id;

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        response.setData(result.getBody());
        return response;
    }
}
