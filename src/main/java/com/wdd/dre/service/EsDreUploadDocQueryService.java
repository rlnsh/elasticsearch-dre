package com.wdd.dre.service;

import com.wdd.dre.dto.doc.request.query.QueryUploadDocRecordRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2019/1/3 14:08
 * @Description:
 */
public interface EsDreUploadDocQueryService {

    @RequestMapping("/es/dre/uploadDocRecord/queryList")
    List<Map<String, Object>> queryList(@RequestBody QueryUploadDocRecordRequest request);
}
