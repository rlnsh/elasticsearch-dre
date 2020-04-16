package com.wdd.dre.doc;

import com.alibaba.fastjson.JSONObject;
import com.wdd.dre.domain.entity.EsDreUploadDocumentRecord;
import com.wdd.dre.domain.repository.EsDreUploadDocumentRecordRepository;
import com.wdd.dre.dto.doc.request.query.QueryDocListRequest;
import com.wdd.dre.dto.doc.response.query.QueryDocListResponse;
import com.wdd.dre.service.DocumentQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 16:21
 * @Description: 文档检索测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentQueryServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(DocumentQueryServiceTest.class);

    @Autowired private DocumentQueryService documentQueryService;

    @Autowired private EsDreUploadDocumentRecordRepository uploadDocumentRecordRepository;

    /**
     * 根据条件查询文档列表
     */
    @Test
    public void queryDocListTest() {
        QueryDocListRequest request = new QueryDocListRequest();
        request.setPageIndex(1L);
        request.setPageSize(2L);
        request.setContent("海康");
        QueryDocListResponse response = documentQueryService.queryDocList(request);
        logger.info("返回结果：{}", JSONObject.toJSONString(response));
    }

    @Test
    public void queryEsDreUploadDocTest() {
        List<EsDreUploadDocumentRecord> list = uploadDocumentRecordRepository.findAll();

        logger.info("返回结果：{}", JSONObject.toJSONString(list));
    }
}
