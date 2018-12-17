package com.hikvision.dre.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.bean.es.upload.request.EsUploadDocRequestBean;
import com.hikvision.dre.common.ESApiConstantsService;
import com.hikvision.dre.dto.doc.request.DeleteDocByIdRequest;
import com.hikvision.dre.dto.doc.request.UpdateDocByIdRequest;
import com.hikvision.dre.dto.doc.request.upload.UploadDocumentRequest;
import com.hikvision.dre.dto.doc.response.DeleteDocByIdResponse;
import com.hikvision.dre.dto.doc.response.UpdateDocByIdResponse;
import com.hikvision.dre.dto.doc.response.upload.UploadDocumentResponse;
import com.hikvision.dre.exception.ErrorCode;
import com.hikvision.dre.service.DocumentService;
import com.hikvision.dre.util.FileUtil;
import com.hikvision.dre.util.GenerateSearchApiUtil;
import com.hikvision.dre.util.RestTemplateUtil;
import com.hikvision.dre.domain.generator.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:46
 * @Description: 文档增删改服务实现类
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private static final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired private ESApiConstantsService esApiConService;

    /**
     * 上传文档数据到ES
     * @param request
     * @return
     */
    @Override
    public UploadDocumentResponse uploadDocument(UploadDocumentRequest request) {
        UploadDocumentResponse response = new UploadDocumentResponse();

        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker();
        long id = snowflakeIdWorker.nextId();

        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + id + esApiConService.ES_URL_PIPELINE_DOC_SUFFIX;
        EsUploadDocRequestBean esUploadDocRequestBean = new EsUploadDocRequestBean();
        BeanUtils.copyProperties(request, esUploadDocRequestBean);
        try {
            String data = FileUtil.encodeBase64File(request.getFilePath());
            esUploadDocRequestBean.setData(data);
        } catch (Exception e) {
            logger.error("文件Base64编码错误", e);
            response.setCode(ErrorCode.SELF_PROGRAMER);
            response.setMsg("文件Base64编码错误！");
            return response;
        }
        logger.info("上传文档到ES-params:{}", JSONObject.toJSONString(request));
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, RestTemplateUtil.getRequestBody(esUploadDocRequestBean), String.class);
        response.setResult(result.getBody());
        return response;
    }

    /**
     * 根据ID更新文档信息
     * @param request
     * @return
     */
    @Override
    public UpdateDocByIdResponse updateDocById(UpdateDocByIdRequest request) {
        UpdateDocByIdResponse response = new UpdateDocByIdResponse();
        if (request.getId() == null) {
            response.setCode(ErrorCode.FORM_ERROR);
            response.setMsg("文档id不能为空!");
        }

        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + request.getId() + esApiConService.SLASH + esApiConService.ES_URL_UPDATE_SUFFIX;
        String updateBody;
        try {
            updateBody = GenerateSearchApiUtil.getScriptedUpdates(request, UpdateDocByIdRequest.class);
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
    @Override
    public DeleteDocByIdResponse deleteDocById(DeleteDocByIdRequest request) {
        DeleteDocByIdResponse response = new DeleteDocByIdResponse();
        if (request.getId() == null) {
            response.setCode(ErrorCode.FORM_ERROR);
            response.setMsg("文档id不能为空!");
        }
        String url = esApiConService.ES_URL_DOC_PREFIX + esApiConService.SLASH + request.getId();

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        response.setData(result.getBody());
        return response;
    }
}
