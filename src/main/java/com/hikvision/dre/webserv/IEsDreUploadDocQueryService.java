package com.hikvision.dre.webserv;

import com.hikvision.dre.common.BaseController;
import com.hikvision.dre.dto.doc.request.query.QueryUploadDocRecordRequest;
import com.hikvision.dre.service.EsDreUploadDocQueryService;
import com.hikvision.dre.service.impl.EsDreUploadDocQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2019/1/3 14:11
 * @Description:
 */
@RestController
public class IEsDreUploadDocQueryService extends BaseController implements EsDreUploadDocQueryService {

    @Autowired private EsDreUploadDocQueryServiceImpl uploadDocQueryService;

    @Override
    public List<Map<String, Object>> queryList(@RequestBody QueryUploadDocRecordRequest request) {
        return uploadDocQueryService.queryList(request);
    }
}
