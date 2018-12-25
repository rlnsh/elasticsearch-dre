package com.hikvision.dre.repository;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.domain.entity.EsDreIndex;
import com.hikvision.dre.domain.entity.EsDreUploadDocumentRecord;
import com.hikvision.dre.domain.repository.EsDreUploadDocumentRecordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 17:05
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDreUploadDocumentRecordTest {

    private static final Logger logger = LoggerFactory.getLogger(EsDreUploadDocumentRecordTest.class);

    @Autowired private EsDreUploadDocumentRecordRepository uploadDocumentRecordRepository;

    @Autowired private JdbcTemplate jdbcTemplate;

    /**
     * 保存文档上传记录
     */
    @Test
    @Transactional
    public void saveEsDreIndex() {
        EsDreUploadDocumentRecord record = new EsDreUploadDocumentRecord();
        record.setFileName("新员工入职指南");
        record.setFilePath("D:\\帮助\\OA\\新员工入职指南.docx");
        record.setFileType("docx");
        record.setFileSize(284001L);
        record.setPublishDate(new Date());
        uploadDocumentRecordRepository.save(record);

        int a = 1/0;
    }

    /**
     * 更新文档上传记录
     */
    @Test
    public void updateEsDreIndex() {
        EsDreUploadDocumentRecord record = uploadDocumentRecordRepository.findById(1074614420956569600L).get();
        logger.info("开始更新....record: {}", JSONObject.toJSONString(record));
        record.setFileName("新员工入职指南");
        record.setFilePath("D:\\帮助\\OA\\新员工入职指南.docx");
        record.setFileType("docx");
        record.setFileSize(284004L);
        record.setPublishDate(new Date());
        uploadDocumentRecordRepository.save(record);

//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        logger.info("更新完毕....");
    }

    @Test
    public void updateRecordByJdbc() {
        String id = "1074876586158755840";
        String sql = "UPDATE es_dre_upload_document_record " +
                " SET file_name = CONCAT(file_name,\".BACKUP\"), version=version+1, modify_time = NOW()" +
                " WHERE id = ?";
        int a = jdbcTemplate.update(sql, id);
        logger.info("a:{}", a);
    }
}
