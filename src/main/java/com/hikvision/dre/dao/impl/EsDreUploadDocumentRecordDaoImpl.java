package com.hikvision.dre.dao.impl;

import com.hikvision.dre.dao.EsDreUploadDocumentRecordDao;
import com.hikvision.dre.domain.entity.EsDreUploadDocumentRecord;
import com.hikvision.dre.domain.repository.EsDreUploadDocumentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 10:31
 * @Description:
 */
@Service
@Transactional
public class EsDreUploadDocumentRecordDaoImpl implements EsDreUploadDocumentRecordDao {

    @Autowired private EsDreUploadDocumentRecordRepository uploadDocRespository;

    /**
     * 保存上传文档到ES记录
     * @param record
     * @return id
     */
    @Override
    public long save(EsDreUploadDocumentRecord record) {
        uploadDocRespository.save(record);
        return record.getId();
    }
}
