package com.hikvision.dre.doc;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.dto.doc.request.DeleteDocByIdRequest;
import com.hikvision.dre.dto.doc.request.UpdateDocByIdRequest;
import com.hikvision.dre.dto.doc.request.upload.UploadDocumentRequest;
import com.hikvision.dre.dto.doc.response.DeleteDocByIdResponse;
import com.hikvision.dre.dto.doc.response.UpdateDocByIdResponse;
import com.hikvision.dre.dto.doc.response.upload.UploadDocumentResponse;
import com.hikvision.dre.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 20:05
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(DocumentServiceTest.class);

    @Autowired private DocumentService documentService;

    /**
     * 上传文档数据
     */
    @Test
    public void uploadDocumentTest() {
        String filePath = "D:\\帮助\\OA\\新员工入职指南.docx";
        UploadDocumentRequest request = new UploadDocumentRequest();
        request.setFileName("新员工入职指南");
        request.setTitle("新员工入职指南");
        request.setAuthor("HR");
        request.setSummary("summary");
        request.setPublishDate("2018-12-14 10:00:00");
        request.setDocType(filePath.substring(filePath.lastIndexOf(".") + 1));
        request.setFilePath(filePath);
        logger.info("入参：{}", JSONObject.toJSONString(request));
        UploadDocumentResponse response = documentService.uploadDocument(request);

        logger.info("返回结果：{}", JSONObject.toJSONString(response));
    }

    /**
     * 根据id删除文档
     */
    @Test
    public void deleteDocByIdTest() {
        DeleteDocByIdRequest request = new DeleteDocByIdRequest();
        request.setId("1073466314818859008");
        DeleteDocByIdResponse response = documentService.deleteDocById(request);
        logger.info("返回结果：{}", JSONObject.toJSONString(response));
    }

    /**
     * 根据id更新文档
     */
    @Test
    public void updateDocByIdTest() {
        UpdateDocByIdRequest request = new UpdateDocByIdRequest();
        request.setId("1073464275682504704");
        request.setAuthor("eee");
        request.setPublishDate("2019-10-10 12:34:45");
        request.setSummary("这个是摘要");
        request.setTitle("这是标题");
        request.setContent("内容");
        UpdateDocByIdResponse response = documentService.updateDocById(request);
        logger.info("返回结果：{}", JSONObject.toJSONString(response));
    }
}
