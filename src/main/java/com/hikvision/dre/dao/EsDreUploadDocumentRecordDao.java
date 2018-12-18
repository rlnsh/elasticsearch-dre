package com.hikvision.dre.dao;

import com.hikvision.dre.domain.entity.EsDreUploadDocumentRecord;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/18 10:30
 * @Description:
 */
public interface EsDreUploadDocumentRecordDao {

    /**
     * 保存上传文档到ES记录
     * @param record
     * @return
     */
    long save(EsDreUploadDocumentRecord record);
}
