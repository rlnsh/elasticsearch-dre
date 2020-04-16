package com.wdd.dre.dao.impl;

import com.wdd.dre.dao.EsDreUploadDocumentRecordQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2019/1/3 14:05
 * @Description:
 */
@Service
public class EsDreUploadDocumentRecordQueryDaoImpl implements EsDreUploadDocumentRecordQueryDao{

    @Autowired private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> queryList() {
        String sql = "SELECT * FROM es_dre_upload_document_record";
        return jdbcTemplate.queryForList(sql);
    }
}
