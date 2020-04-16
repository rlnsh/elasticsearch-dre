package com.wdd.dre.dao;

import com.wdd.dre.domain.entity.EsDreUploadDocumentRecord;

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

    /**
     * 根据id删除记录
     * @param id 记录id
     */
    void delete(Long id);

}
