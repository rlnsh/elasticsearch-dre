package com.hikvision.dre.doc;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.dto.doc.request.query.QueryDocListRequest;
import com.hikvision.dre.dto.doc.response.query.QueryDocListResponse;
import com.hikvision.dre.service.DocumentQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    /**
     * 根据条件查询文档列表
     */
    @Test
    public void queryDocListTest() {
        QueryDocListRequest request = new QueryDocListRequest();
        request.setPageIndex(1);
        request.setPageSize(2);
        request.setContent("海康");
        QueryDocListResponse response = documentQueryService.queryDocList(request);
        logger.info("返回结果：{}", JSONObject.toJSONString(response));
    }
}
