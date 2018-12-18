package com.hikvision.dre.util;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.bean.es.dictionary.ESTermsEnum;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 15:34
 * @Description: 生成ES查询语句工具类
 */
public class GenerateSearchApiUtil {

    /**
     * 根据对象获取bool_must_query语句
     * @param o
     * @param c
     * @return
     */
    public static String getBoolMustQueryDSL(Object o, Class<?> c) throws IllegalAccessException {
        Map<String, Object> queryMap = new HashMap<>();
        Map<String, Object> boolMap = new HashMap<>();
        Map<String, Object> mustMap = new HashMap<>();
        Map<String, Object> highlightMap = genHighlightMap();
        List<Map<String, Object>> mustMapList = genMustMatchMapList(o, c);
        mustMap.put("must", mustMapList);
        boolMap.put("bool", mustMap);
        queryMap.put("query", boolMap);
        queryMap.put("highlight", highlightMap);
        queryMap.put("from", getFrom(o, c));
        queryMap.put("size", getSize(o, c));
        return JSONObject.toJSONString(queryMap);
    }

    /**
     * 生成query-terms DSL
     * @param values
     * @param esTermsEnum
     * @return
     */
    public static String genQueryTermsDSL(String[] values, ESTermsEnum esTermsEnum) {
        Map<String, Object> queryMap = new HashMap<>();
        Map<String, Object> termsMap = new HashMap<>();
        Map<String, Object> keyMap = new HashMap<>();
        keyMap.put(esTermsEnum.getKey(), values);
        termsMap.put("terms", keyMap);
        queryMap.put("query", termsMap);
        return JSONObject.toJSONString(queryMap);
    }

    /**
     * 根据对象生成must_match MapList
     * @param o
     * @param c
     */
    private static List<Map<String, Object>> genMustMatchMapList(Object o, Class<?> c) throws IllegalAccessException {
        List<Map<String, Object>> mustMapList = new ArrayList<>();

        Field[] fields = c.getDeclaredFields( ); // 获取类中的全部定义字段
        // 循环遍历字段，获取字段相应的属性值
        for ( Field field : fields ) {
            String fieldName = field.getName() != null ? field.getName() : "";
            if ("serialVersionUID".equals(fieldName)) {
                continue;
            }
            field.setAccessible(true); // 假设不为空。设置可见性，然后返回
            Object fieldValue = field.get(o); // 设置字段可见，就可以用get方法获取属性值。
            if (!"".equals(fieldName) && fieldValue != null) {
                Map<String, Object> matchMap = new HashMap<>();
                Map<String, Object> fieldMap = new HashMap<>();
                fieldName = "content".equals(fieldName) ? "attachment.content" : fieldName;
                fieldMap.put(fieldName, fieldValue);
                matchMap.put("match", fieldMap);
                mustMapList.add(matchMap);
            }
        }
        return mustMapList;
    }

    /**
     * 生成highlightMap
     * @return
     */
    private static Map<String, Object> genHighlightMap() {
        Map<String, Object> fieldsMap = new HashMap<>();
        Map<String, Object> attachmentMap = new HashMap<>();
        attachmentMap.put("attachment.content", new HashMap<>());
        fieldsMap.put("fields", attachmentMap);
        return fieldsMap;
    }

    /**
     * 得到从第几条开始
     * @param o
     * @param c
     * @return
     * @throws IllegalAccessException
     */
    private static Object getFrom(Object o, Class<?> c) throws IllegalAccessException {
        //分页信息
        Object from = 0L;
        Class<?> supper = c.getSuperclass();
        Field[] fields = supper.getDeclaredFields( );
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName() != null ? field.getName() : "";
            if ("from".equals(fieldName)) {
                from = field.get(o) != null ? field.get(o) : 0;
            }
        }
        return from;
    }

    /**
     * 得到返回多少条
     * @param o
     * @param c
     * @return
     * @throws IllegalAccessException
     */
    private static Object getSize(Object o, Class<?> c) throws IllegalAccessException {
        //分页信息
        Object size = 10;
        Class<?> supper = c.getSuperclass();
//        if (supper.isInstance(AppPagingRequest.class)) {
            Field[] fields = supper.getDeclaredFields( );
            for (Field field : fields) {
                field.setAccessible(true); // 假设不为空。设置可见性，然后返回
                String fieldName = field.getName() != null ? field.getName() : "";
                if ("size".equals(fieldName)) {
                    size = field.get(o) != null ? field.get(o) : 10;
                }
            }
//        }
        return size;
    }

}
