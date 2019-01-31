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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDreApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchDreApplicationTests.class);

    @Autowired private RestTemplate restTemplate;

    @Autowired private ESApiConstantsService esApiConService;

    @Test
    public void queryESTest() {
        String url = ESApiConstants.getEsUrl() + esApiConService.SLASH + "_cat/indices?v";
        String queryBody = "{}";
        logger.info("ES-检索body:{}", queryBody);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, RestTemplateUtil.getRequestBody(queryBody), String.class);
        logger.info("返回结果：{}", JSONObject.toJSONString(responseEntity));
    }

    @Test
    public void postTest() {
        String url = "http://10.14.69.239:9999/artemis/api/salzburg/v1/componentModelManager/componentModelManagerQuery/queryComponentListByCid";
        HttpMethod httpMethod = HttpMethod.POST;
        MultiValueMap<String, String> queryBody = new LinkedMultiValueMap<>();
        queryBody.add("c_component_id_list", "[\"dac\",\"nms\"]");
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, httpMethod, this.getRequestBody(queryBody), String.class);
        logger.info("返回结果：{}", responseEntity.getBody());
    }

    public static <T> HttpEntity<T> getRequestBody(T requestStr) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("access_token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJzY29wZSJdLCJleHAiOjE1NDg5NTgwNjYsImp0aSI6ImRiYTJlNzVhLTA5OTAtNDY1Yy04MWRiLWRiZjFmMWZjM2Y2OSIsImNsaWVudF9pZCI6IjIyNjI5NzYwIn0.kpRZxiolOOl-QUD-JDZkRCm-uvib6aAHzwWzwRRXAmA");
        return new HttpEntity<>(requestStr, headers);
    }
}

