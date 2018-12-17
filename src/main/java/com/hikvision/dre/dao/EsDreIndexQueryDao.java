package com.hikvision.dre.dao;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 16:27
 * @Description:
 */
public interface EsDreIndexQueryDao {

    /**
     * 查询索引列表
     * @param code 索引标识
     * @param name 索引名称
     * @param uuid uuid
     * @return
     */
    List<Map<String, Object>> queryList(String code, String name, String uuid);
}
