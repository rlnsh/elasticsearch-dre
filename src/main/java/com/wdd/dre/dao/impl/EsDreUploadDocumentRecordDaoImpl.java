package com.wdd.dre.dao.impl;

import com.wdd.dre.dao.EsDreUploadDocumentRecordDao;
import com.wdd.dre.domain.entity.EsDreUploadDocumentRecord;
import com.wdd.dre.domain.repository.EsDreUploadDocumentRecordRepository;
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

    @Autowired private EsDreUploadDocumentRecordRepository uploadDocRepository;

    /**
     * 保存上传文档到ES记录
     * @param record
     * @return id
     */
    @Override
    public long save(EsDreUploadDocumentRecord record) {
        uploadDocRepository.save(record);
        return record.getId();
    }

    /**
     * 根据id删除记录
     * @param id 记录id
     */
    @Override
    public void delete(Long id) {
        uploadDocRepository.deleteById(id);
    }

}
