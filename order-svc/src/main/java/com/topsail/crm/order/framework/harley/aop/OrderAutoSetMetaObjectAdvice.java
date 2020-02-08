package com.topsail.crm.order.framework.harley.aop;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.asiainfo.areca.framework.threadlocal.RequestTimeHolder;
import com.asiainfo.areca.framework.util.Constants;
import com.asiainfo.areca.framework.util.WebContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 实现公共字段自动设置
 *
 * @author jinnian
 * @date 2020-02-08
 */
@Slf4j
@Component
public class OrderAutoSetMetaObjectAdvice implements MetaObjectHandler {

    /**
     * 记录创建时间
     */
    private static final String CREATE_DATE = "createDate";

    /**
     * 记录创建员工
     */
    private static final String CREATE_OP_ID = "createOpId";

    /**
     * 记录创建部门
     */
    private static final String CREATE_ORG_ID = "createOrgId";

    /**
     * 记录更新时间
     */
    private static final String DONE_DATE = "doneDate";

    /**
     * 记录更新员工
     */
    private static final String OP_ID = "opId";

    /**
     * 记录更新时间
     */
    private static final String ORG_ID = "orgId";

    /**
     * 在新增记录时自动设置。
     *
     * @param metaObject 源对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime requestTime = getRequestTime();
        this.strictInsertFill(metaObject, CREATE_DATE, LocalDateTime.class, requestTime);
        this.strictInsertFill(metaObject, DONE_DATE, LocalDateTime.class, requestTime);
    }

    /**
     * 在修改记录时自动设置
     *
     * @param metaObject 源对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime requestTime = getRequestTime();
        this.strictUpdateFill(metaObject, DONE_DATE, LocalDateTime.class, requestTime);
    }

    private Long getUserId() {
        Long userId = null;
        try {
            userId = WebContextUtils.getUserContext().getUserId();
        } catch(Exception e) {
            userId = Constants.DEFAULT_USER_ID;
        }
        return userId;
    }

    private LocalDateTime getRequestTime() {
        LocalDateTime requestTime = RequestTimeHolder.getRequestTime();
        if (null == requestTime) {
            requestTime = LocalDateTime.now();
        }
        return requestTime;
    }
}
