package com.hikvision.dre.domain.repository;

import com.hikvision.dre.domain.EsDreUploadDocumentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 11:40
 * @Description:
 */
public interface EsDreUploadDocumentRecordRepository extends JpaRepository<EsDreUploadDocumentRecord, Long> {
}
