package com.hikvision.dre.dao.impl;

import com.hikvision.dre.dao.EsDreIndexQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 16:27
 * @Description:
 */
@Service
public class EsDreIndexQueryDaoImpl implements EsDreIndexQueryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询索引列表
     * @param code 索引标识
     * @param name 索引名称
     * @param uuid uuid
     * @return
     */
    @Override
    public List<Map<String, Object>> queryList(String code, String name, String uuid) {
        String sql = "SELECT id, `code`, `name`, type, uuid" +
                " FROM es_dre_index" +
                " WHERE 1=1";
        List<Object> params = new ArrayList<>();
        if (code != null) {
            sql += " AND `code` = ?";
            params.add(code);
        }
        if (name != null) {
            sql += " AND `name` LIKE ?";
            params.add("%" + name + "%");
        }
        if (uuid != null) {
            sql += " AND uuid = ?";
            params.add(uuid);
        }
        return jdbcTemplate.queryForList(sql, params.toArray());
    }
}
