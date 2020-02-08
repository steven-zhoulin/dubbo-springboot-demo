package com.topsail.crm.order.framework.harley.annotation;

import java.lang.annotation.*;

/**
 * @program: crm
 * @description: 工作站注解
 * @author: jinnian
 * @create: 2020-02-07 20:22
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@Documented
public @interface Workstation {
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
     * 场景类型 0-正常 1-返销 2-取消
     * @return
     */
    String scenType() default "0";

    /**
     * spring spel动态表达式
     * @return
     */
    String spel() default "";

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
