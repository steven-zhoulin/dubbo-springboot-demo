package com.topsail.crm.order.framework.harley.interfaces;

import java.util.Map;

/**
 * @program: crm-V0
 * @description: 异常过滤类，当业务发生异常时，也需要返回输出信息时使用
 * @author: jinnian
 * @create: 2020-01-19 15:07
 **/
public interface IFilterException {

    public void filter(Throwable e, Map request, Map response) throws Exception;

}
