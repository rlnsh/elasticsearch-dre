package com.hikvision.dre.domain.repository;

import com.hikvision.dre.domain.entity.EsDreUploadDocumentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 11:40
 * @Description:
 */
public interface EsDreUploadDocumentRecordRepository extends JpaRepository<EsDreUploadDocumentRecord, Long> {

    /**
     * 根据id,status查询
     * 使用命名化参数，使用@Param
     * @param id
     * @param status
     * @return
     */
    @Query("select r from  EsDreUploadDocumentRecord r where r.id = :id and r.status = :status")
    EsDreUploadDocumentRecord getById(@Param("id") Long id, @Param("status") Integer status);

    /**
     * 根据id,status查询
     * JpaRepository支持接口规范方法名查询。意思是如果在接口中定义的查询方法符合它的命名规则，就可以不用写实现
     * @param id
     * @param status
     * @return
     */
    EsDreUploadDocumentRecord findByIdAndStatus(Long id, Integer status);
}
