package com.wdd.dre;

import com.alibaba.fastjson.JSONObject;
import com.wdd.dre.common.ESApiConstants;
import com.wdd.dre.common.ESApiConstantsService;
import com.wdd.dre.util.RestTemplateUtil;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
//        String url = "http://10.14.69.239:9999/artemis/api/salzburg/v1/componentModelManager/componentModelManagerQuery/queryComponentListByCid";
//        String url = "http://10.14.69.239:9999/artemis/api/salzburg/v1/componentModelManager/componentModelManagerQuery/queryComponentChangelogList";
//        String url = "http://pc-hz20103984.wdd.com:58140/componentModelManagerQuery/queryComponentChangelogList";
//        String url = "http://10.14.69.239:9999/artemis/api/salzburg/v1/dictionary/queryDicList";
        String url = "http://10.14.69.238:8081/idsPresetManage/presetResourceSelectService/external/v1/originAndResource/batch/save";
        HttpMethod httpMethod = HttpMethod.POST;
        MultiValueMap<String, String> queryBody = new LinkedMultiValueMap<>();
//        queryBody.add("id_version_list", "[{\"c_component_id\":\"dac\",\"c_version_no\":\"1.7.0\"},{\"c_component_id\":\"nms\",\"c_version_no\":\"1.3.0\"}]");
        queryBody.add("c_dict_type_s", "department,category");
        queryBody.add("c_dict_code_s", "department");
//        List<Map<String, Object>> params = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("c_dict_type_s", "department,category");
        map.put("c_dict_code_s", "department");
//        params.add(map);
        String requestStr = "[{\"objectId\":\"teset1231\",\"versionNo\":\"1.0.0_ci456_build111111\",\"name\":\"测试核心服务数据1\",\"sourceNo\":\"1231424\",\"versionSource\":\"controlled\",\"originType\":\"bic\",\"presetResourceList\":[{\"identification\":\"test1231_1\",\"versionNo\":\"1.0.0_ci123_build12323\",\"name\":\"测试预置组件数据2\",\"versionSource\":\"controlled\",\"controlledNo\":\"5555\",\"type\":\"component\"}]}]";
        HttpEntity httpEntity = this.getRequestBody(requestStr);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, String.class);
        logger.info("返回结果：{}", responseEntity.getBody());
    }

    /**
     * 测试RequestBody请求
     * 服务端：
     * 1. 入参使用@RequestBody注解
     * 2. 入参须使用POJO
     * 客户端：
     * 1. 入参须使用POJO
     * 2. Content-Type需要application/json
     */
    @Test
    public void postRequestBodyTest() {
//        String url = "http://10.14.69.239:9999/artemis/api/salzburg/v1/componentModelManager/componentModelManagerQuery/queryComponentListByCid";
//        String url = "http://10.14.69.239:9999/artemis/api/salzburg/v1/componentModelManager/componentModelManagerQuery/queryComponentChangelogList";
        String url = "http://pc-hz20103984.wdd.com:58140/componentModelManagerQuery/queryComponentChangelogListTest";
        HttpMethod httpMethod = HttpMethod.POST;
        List<Map<String, Object>> params = new ArrayList<>();

        QueryComponentChangelogListRequest request = new QueryComponentChangelogListRequest();
        Map<String, Object> map = new HashMap<>();
        map.put("c_component_id", "dac");
        map.put("c_version_no", "1.7.0");
        params.add(map);
        request.setId_version_list(params);
        HttpEntity httpEntity = this.getRequestBody(request);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, String.class);
        logger.info("返回结果：{}", responseEntity.getBody());
    }

    public static <T> HttpEntity<T> getRequestBody(T requestStr) {
        HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_FORM_URLENCODED_VALUE + "; charset=UTF-8");
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("access_token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJzY29wZSJdLCJleHAiOjE1NDkwMjY1NjMsImp0aSI6IjM2NWE2YzBjLTdhYmYtNGNmMi1hNThmLTg5MjVlOGRlODk0ZiIsImNsaWVudF9pZCI6IjIyNjI5NzYwIn0.8GLvXiYzCA7ZPzqplLWE5Quk3Eoqc_S74_77Zb7ItBw");
        return new HttpEntity<>(requestStr, headers);
    }

    /**
     * 根据标识/版本号查询组件changelog-批量查询
     * @param request
     * @return
     */
    @PostMapping("/queryComponentChangelogListTest")
    public List<Map<String, Object>> queryComponentChangelogListTest(@RequestBody QueryComponentChangelogListRequest request){
            List<Map<String, Object>> id_version_list = request.getId_version_list();
            return null;
    }
}

