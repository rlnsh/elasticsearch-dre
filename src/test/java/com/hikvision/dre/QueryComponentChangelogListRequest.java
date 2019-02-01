package com.hikvision.dre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2019/2/1 09:30
 * @Description:
 */
public class QueryComponentChangelogListRequest implements Serializable {

    private static final long serialVersionUID = 4202381616759935395L;
    private List<Map<String, Object>> id_version_list = new ArrayList<>();

    public List<Map<String, Object>> getId_version_list() {
        return id_version_list;
    }

    public void setId_version_list(List<Map<String, Object>> id_version_list) {
        this.id_version_list = id_version_list;
    }
}
