package com.topsail.crm.framework.aop;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.topsail.crm.framework.threadlocal.RequestTimeHolder;
import com.topsail.crm.framework.util.Constants;
import com.topsail.crm.framework.util.WebContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 实现公共字段自动设置
 *
 * @author Steven
 * @date 2019-04-28
 */
@Slf4j
@Component
public class AutoSetMetaObjectAdvice implements MetaObjectHandler {

    /**
     * 记录创建时间
     */
    private static final String CREATE_TIME = "createTime";

    /**
     * 记录更新时间
     */
    private static final String UPDATE_TIME = "updateTime";

    /**
     * 记录创建工号
     */
    private static final String CREATE_USER_ID = "createUserId";

    /**
     * 记录更新工号
     */
    private static final String UPDATE_USER_ID = "updateUserId";

    /**
     * 在新增记录时自动设置。
     *
     * @param metaObject 源对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        Long userId = getUserId();
        LocalDateTime requestTime = getRequestTime();

        this.setInsertFieldValByName(CREATE_TIME, requestTime, metaObject);
        this.setInsertFieldValByName(UPDATE_TIME, requestTime, metaObject);
        this.setInsertFieldValByName(CREATE_USER_ID, userId, metaObject);
        this.setInsertFieldValByName(UPDATE_USER_ID, userId, metaObject);
    }

    /**
     * 在修改记录时自动设置
     *
     * @param metaObject 源对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = getUserId();
        LocalDateTime requestTime = getRequestTime();

        this.setUpdateFieldValByName(UPDATE_TIME, requestTime, metaObject);
        this.setUpdateFieldValByName(UPDATE_USER_ID, userId, metaObject);
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
