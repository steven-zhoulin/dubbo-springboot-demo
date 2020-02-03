package com.topsail.crm.order.framework.harley.interfaces;

import java.util.Map;

/**
 * @program: crm-V0
 * @description: 业务服务的出参过滤器
 * @author: jinnian
 * @create: 2020-01-19 15:07
 **/
public interface IFilterOut {

    public void filter(Map request, Map response);

}
