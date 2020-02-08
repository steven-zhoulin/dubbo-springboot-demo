package com.topsail.crm.order.framework.harley.context;

import com.asiainfo.areca.framework.threadlocal.RequestTimeHolder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: crm-V0
 * @description: 业务服务的环境相关信息
 * @author: jinnian
 * @create: 2020-01-19 15:14
 **/
@Data
public class Environment {

    private String opId;

    private String opName;

    private String orgId;

    private String orgName;

    private LocalDateTime acceptTime;

    private String channel;

    private String serviceName;

    private String sessionId;

    private String district;

    private String country;

    /**
     * 根据会话构造
     */
    public Environment() {
        this.acceptTime = RequestTimeHolder.getRequestTime();
        this.channel = "0";
        this.opId = "SUPERUSR";
        this.orgId = "00000";
    }
}
