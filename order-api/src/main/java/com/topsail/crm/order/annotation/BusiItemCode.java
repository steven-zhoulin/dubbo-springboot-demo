package com.topsail.crm.order.annotation;

/**
 * @program: crm
 * @description: 定义业务类型，作用在订单创建时基于用户的业务数据传输对象（UserRequestDTO)上<br/>
 *               如果一个DTO可以通用于多个业务类型，则值设为-1，将业务类型的设置值交由DTO对象本身去设置
 * @author: jinnian
 * @create: 2020-01-19 17:59
 **/
public @interface BusiItemCode {

    /**
     * 定义具体的业务类型
     * @return
     */
    String value();
}
