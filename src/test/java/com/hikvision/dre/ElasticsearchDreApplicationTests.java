package com.hikvision.dre;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.common.ESApiConstants;
import com.hikvision.dre.common.ESApiConstantsService;
import com.hikvision.dre.util.RestTemplateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDreApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchDreApplicationTests.class);

    @Autowired private RestTemplate restTemplate;

    @Autowired private ESApiConstantsService esApiConService;

    @Test
    public void queryESTest() {
        String url = ESApiConstants.ES_URL + esApiConService.SLASH + "_cat/indices?v";
        String queryBody = "{}";
        logger.info("ES-检索body:{}", queryBody);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, RestTemplateUtil.getRequestBody(queryBody), String.class);
        logger.info("返回结果：{}", JSONObject.toJSONString(responseEntity));
    }

}

