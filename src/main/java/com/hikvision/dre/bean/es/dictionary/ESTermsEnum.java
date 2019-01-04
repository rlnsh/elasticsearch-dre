package com.hikvision.dre.bean.es.dictionary;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 14:45
 * @Description: ES Terms枚举
 */
public enum ESTermsEnum {

    ID("_id", "文档id"),
    INDEX("_index", "索引"),
    TYPE("_type", "类型");

    private String key;

    private String value;

    ESTermsEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
