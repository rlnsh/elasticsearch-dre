package com.hikvision.dre.bean.es.query.response.metadata;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 16:39
 * @Description: ES分片信息
 */
public class Shards implements Serializable {

    private static final long serialVersionUID = -8799173752469230942L;
    private Integer total;

    private Integer successful;

    private Integer skipped;

    private Integer failed;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSuccessful() {
        return successful;
    }

    public void setSuccessful(Integer successful) {
        this.successful = successful;
    }

    public Integer getSkipped() {
        return skipped;
    }

    public void setSkipped(Integer skipped) {
        this.skipped = skipped;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }
}
