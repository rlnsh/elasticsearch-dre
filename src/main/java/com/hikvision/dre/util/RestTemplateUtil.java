package com.hikvision.dre.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 11:50
 * @Description: RestTemplate工具类
 */
public class RestTemplateUtil {

    public static <T> HttpEntity<T> getRequestBody(T requestStr) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return new HttpEntity<>(requestStr, headers);
    }
}
