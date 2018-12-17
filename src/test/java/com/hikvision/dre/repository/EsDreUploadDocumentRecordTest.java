package com.hikvision.dre.repository;

import com.hikvision.dre.domain.entity.EsDreIndex;
import com.hikvision.dre.domain.entity.EsDreUploadDocumentRecord;
import com.hikvision.dre.domain.repository.EsDreUploadDocumentRecordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 17:05
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDreUploadDocumentRecordTest {

    @Autowired private EsDreUploadDocumentRecordRepository uploadDocumentRecordRepository;

    /**
     * 保存索引
     */
    @Test
    public void saveEsDreIndex() {
        EsDreUploadDocumentRecord record = new EsDreUploadDocumentRecord();
        record.setFileName("新员工入职指南");
        record.setFilePath("D:\\帮助\\OA\\新员工入职指南.docx");
        record.setFileType("docx");
        record.setFileSize(284001L);
        record.setPublishDate(new Date());
        uploadDocumentRecordRepository.save(record);
    }
}
