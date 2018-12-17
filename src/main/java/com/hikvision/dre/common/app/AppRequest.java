package com.hikvision.dre.common.app;

import java.io.Serializable;
import java.util.UUID;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/13 20:37
 * @Description: 入参基类
 */
public abstract class AppRequest implements Serializable {

    private static final long serialVersionUID = -6907842080246753978L;

    protected String requestId = UUID.randomUUID().toString();

}
