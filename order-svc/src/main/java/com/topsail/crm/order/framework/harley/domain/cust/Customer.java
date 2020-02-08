package com.topsail.crm.order.framework.harley.domain.cust;

import lombok.Data;

/**
 * @program: crm
 * @description: 客户对象，数据由跨中心服务获得
 * @author: jinnian
 * @create: 2020-01-20 00:44
 **/
@Data
public class Customer {

    private Long custId = new Long(2);

    private String custName = "nobody";
}
