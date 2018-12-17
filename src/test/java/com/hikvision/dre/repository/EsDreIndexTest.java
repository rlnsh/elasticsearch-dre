package com.hikvision.dre.repository;

import com.hikvision.dre.domain.entity.EsDreIndex;
import com.hikvision.dre.domain.repository.EsDreIndexRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 13:59
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDreIndexTest {

    @Autowired private EsDreIndexRepository indexRepository;
    /**
     * 保存索引
     */
    @Test
    public void saveEsDreIndex() {
        EsDreIndex dreIndex = new EsDreIndex();
        dreIndex.setName("wdd");
        dreIndex.setCode("wdd");
        dreIndex.setType("doc");
        indexRepository.save(dreIndex);
    }
}
