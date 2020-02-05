package com.topsail.crm.order.cell.order.entity.dto;

import lombok.Data;

/**
 * @program: crm
 * @description: 用户业务受理请求对象
 *               基于用户的业务继承此对象
 * @author: jinnian
 * @create: 2020-01-20 01:17
 **/
@Data
public class UserRequestDTO {
    /**
     * 服务号码
     */
    private String accessNum;

    /**
     * 用户状态，不设置则默认取正常用户
     */
    private String subscriberStatus = "0";

    /**
     * 用户ID
     */
    private Long subscriberInsId;

    /**
     * 业务类型，一般无需设置，只有类似停开机业务不同业务类型共用同一个DTO的情况下需要设置，其它只需要设置@BusiItemCode注解
     */
    private String busiItemCode;
}
