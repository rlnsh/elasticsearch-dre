package com.hikvision.dre.bean.es.query.response;

import com.hikvision.dre.bean.es.query.response.metadata.Hits;
import com.hikvision.dre.bean.es.query.response.metadata.Shards;

import java.io.Serializable;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 16:36
 * @Description: ES查询返回信息
 */
public class ESQueryResponseBean implements Serializable {

    private static final long serialVersionUID = -6131309951700408271L;
    /**
     * 检索花费时间
     */
    private Long took;

    /**
     * 是否超时
     */
    private boolean timed_out;

    /**
     * 分片信息
     */
    private Shards _shards;

    /**
     * 匹配结果
     */
    private Hits hits;

    public Long getTook() {
        return took;
    }

    public void setTook(Long took) {
        this.took = took;
    }

    public boolean isTimed_out() {
        return timed_out;
    }

    public void setTimed_out(boolean timed_out) {
        this.timed_out = timed_out;
    }

    public Shards get_shards() {
        return _shards;
    }

    public void set_shards(Shards _shards) {
        this._shards = _shards;
    }

    public Hits getHits() {
        return hits;
    }

    public void setHits(Hits hits) {
        this.hits = hits;
    }
}
