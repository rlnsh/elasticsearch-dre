package com.hikvision.dre.repository;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.dre.dao.EsDreIndexQueryDao;
import com.hikvision.dre.domain.entity.EsDreIndex;
import com.hikvision.dre.domain.repository.EsDreIndexRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 13:59
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDreIndexTest {

    private static final Logger logger = LoggerFactory.getLogger(EsDreIndexTest.class);

    @Autowired private EsDreIndexRepository indexRepository;

    @Autowired private EsDreIndexQueryDao esDreIndexQueryDao;

    /**
     * 保存索引
     */
    @Test
    public void saveEsDreIndex() {
        EsDreIndex dreIndex = new EsDreIndex();
        dreIndex.setName("wdd");
        dreIndex.setCode("wdd2");
        dreIndex.setType("doc");
        indexRepository.save(dreIndex);
    }

    /**
     * 查询索引列表
     */
    @Test
    public void queryListTest() {
        List<Map<String, Object>> list = esDreIndexQueryDao.queryList(null, null, null);
        logger.info("返回结果：{}", JSONObject.toJSONString(list));
    }
}
