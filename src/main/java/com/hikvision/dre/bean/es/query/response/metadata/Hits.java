package com.hikvision.dre.bean.es.query.response.metadata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/14 16:41
 * @Description: 匹配记录
 */
public class Hits implements Serializable {

    private static final long serialVersionUID = 4651675241062814654L;

    private Double max_score;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 匹配列表
     */
    private List<Hit> hits;

    public static class Hit implements Serializable {

        private static final long serialVersionUID = 8983204286423655736L;
        private String _index;

        private String _type;

        private String _id;

        private Double _score;

        /**
         * 检索到的数据源
         */
        private Map<String, Object> _source;

        private Map<String, List<String>> highlight;

        public String get_index() {
            return _index;
        }

        public void set_index(String _index) {
            this._index = _index;
        }

        public String get_type() {
            return _type;
        }

        public void set_type(String _type) {
            this._type = _type;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public Double get_score() {
            return _score;
        }

        public void set_score(Double _score) {
            this._score = _score;
        }

        public Map<String, Object> get_source() {
            return _source;
        }

        public void set_source(Map<String, Object> _source) {
            this._source = _source;
        }

        public Map<String, List<String>> getHighlight() {
            return highlight;
        }

        public void setHighlight(Map<String, List<String>> highlight) {
            this.highlight = highlight;
        }
    }

    public Double getMax_score() {
        return max_score;
    }

    public void setMax_score(Double max_score) {
        this.max_score = max_score;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }
}
