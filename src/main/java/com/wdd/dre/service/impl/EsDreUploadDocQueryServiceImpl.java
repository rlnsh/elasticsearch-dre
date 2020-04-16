package com.wdd.dre.service.impl;

import com.wdd.dre.dao.EsDreUploadDocumentRecordQueryDao;
import com.wdd.dre.dto.doc.request.query.QueryUploadDocRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2019/1/3 14:10
 * @Description:
 */
@Service
public class EsDreUploadDocQueryServiceImpl {

    @Autowired  private EsDreUploadDocumentRecordQueryDao documentRecordQueryDao;

    public List<Map<String, Object>> queryList(QueryUploadDocRecordRequest request) {
        return documentRecordQueryDao.queryList();
    }
}
