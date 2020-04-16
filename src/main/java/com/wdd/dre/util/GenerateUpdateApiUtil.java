package com.wdd.dre.util;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 14:09
 * @Description: 生成ES更新语句工具类
 */
public class GenerateUpdateApiUtil {

    /**
     * 根据对象获取update_script
     * @param o
     * @param c
     * @return
     */
    public static String getScriptedUpdates(Object o, Class<?> c) throws IllegalAccessException {
        Map<String, Object> updateMap = new HashMap<>();
        Map<String, Object> scriptMap = genScriptMap(o, c);
        updateMap.put("script", scriptMap);
        return JSONObject.toJSONString(updateMap);
    }

    /**
     * 生成scriptMap
     * @param o
     * @param c
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, Object> genScriptMap(Object o, Class<?> c) throws IllegalAccessException {
        Map<String, Object> scriptMap = new HashMap<>();
        Map<String, Object> paramsMap = new HashMap<>();

        StringBuffer stringBuffer = new StringBuffer();
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
//                source += "ctx._source." + ("content".equals(fieldName) ? "attachment.content" : fieldName) + "=params." + fieldName + ";";
                stringBuffer.append("ctx._source.");
                stringBuffer.append("content".equals(fieldName) ? "attachment.content" : fieldName);
                stringBuffer.append("=params.");
                stringBuffer.append(fieldName);
                stringBuffer.append(";");
                paramsMap.put(fieldName, fieldValue);
            }
        }
        String source = stringBuffer.toString();
        if (source.length() > 0) {
            source = source.substring(0, source.length() - 1);
        }
        scriptMap.put("source", source);
        scriptMap.put("params", paramsMap);
        return scriptMap;
    }
}
