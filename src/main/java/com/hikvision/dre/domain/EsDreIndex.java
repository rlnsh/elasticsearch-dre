package com.hikvision.dre.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 10:57
 * @Description: ES索引管理表
 */
@Entity
@Table(name = "es_dre_index", indexes = {@Index(columnList = "code")})
public class EsDreIndex extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.hikvision.dre.domain.generator.SnowflakeIdWorker")
    private Long id;

    /**
     * 索引标识
     */
    @Column(name = "code", nullable = false, columnDefinition = "varchar(30) default ''")
    private String code = "";

    /**
     * 索引名称
     */
    @Column(name = "name", nullable = false, columnDefinition = "varchar(50) default ''")
    private String name = "";

    /**
     * 索引类型-es6.0.x一个索引下只能有一个type
     */
    @Column(name = "type", nullable = false, columnDefinition = "varchar(30) default ''")
    private String type = "";

    /**
     * 保存es系统中的uuid
     */
    @Column(name = "uuid", nullable = false, columnDefinition = "varchar(33) default ''")
    private String uuid = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
