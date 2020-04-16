package com.wdd.dre.util;

import com.wdd.dre.common.ESApiConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Base64;

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
        headers.add("Authorization", getHeader(ESApiConstants.getUserName(), ESApiConstants.getPASSWORD()));
        return new HttpEntity<>(requestStr, headers);
    }

    /**
     * 构造Basic Auth认证头信息
     *
     * @return
     */
    private static String getHeader(String userName, String password) {
        String auth = userName + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = null;
        try {
            authHeader = "Basic " + new String(encodedAuth, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return authHeader;
    }
}
