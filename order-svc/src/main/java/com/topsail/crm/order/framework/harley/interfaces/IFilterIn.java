package com.topsail.crm.order.framework.harley.interfaces;

import java.util.Map;

/**
 * @program: crm-V0
 * @description: 针对业务入参的过滤器 主要完成入参Map当中业务相关key的补充与转换
 * @author: jinnian
 * @create: 2020-01-19 15:07
 **/
public interface IFilterIn {

    public void filter(Map request);

}
