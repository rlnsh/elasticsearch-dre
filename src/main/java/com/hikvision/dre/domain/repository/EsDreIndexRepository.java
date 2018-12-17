package com.hikvision.dre.domain.repository;

import com.hikvision.dre.domain.EsDreIndex;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 11:28
 * @Description:
 */
public interface EsDreIndexRepository extends JpaRepository<EsDreIndex, Long> {
}
