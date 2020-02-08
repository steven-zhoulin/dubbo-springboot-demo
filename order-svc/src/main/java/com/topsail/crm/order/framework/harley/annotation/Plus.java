package com.topsail.crm.order.framework.harley.annotation;

import java.lang.annotation.*;

/**
 * @program: crm
 * @description: 插件注解
 * @author: jinnian
 * @create: 2020-02-07 19:53
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@Documented
public @interface Plus {

    public enum PlusType {
        REG,
        REG_BEFORE_DB,
        REG_AFTER_DB,
        BEFORE_ARCH,
        AFTER_ARCH,
        FINISH,
    }

    /**
     * 业务类型 -1 表示通配
     * @return
     */
    String busiItemCode() default "-1";

    /**
     * 订单类型 -1 表示通配
     * @return
     */
    String busiCode() default  "-1";

    /**
     * 接入渠道 -1 表示通配
     * @return
     */
    String channel() default "-1";

    /**
     * 动态表达式
     * @return
     */
    String expression() default "";

    /**
     * 场景类型 0-正常 1-返销 2-取消
     * @return
     */
    String scenType() default "0";

    /**
     * 取业务类型的方式，1-从注解获取，2-从入参获取
     * @return
     */
    PlusType type() default Plus.PlusType.REG;

    /**
     * 执行顺序
     * @return
     */
    int execNo() default 0;

    /**
     * 状态  U表示有效
     * @return
     */
    String status() default "U";


}
