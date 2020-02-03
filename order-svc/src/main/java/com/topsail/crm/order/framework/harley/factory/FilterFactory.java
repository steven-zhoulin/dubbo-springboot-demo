package com.topsail.crm.order.framework.harley.factory;

import com.topsail.crm.order.framework.harley.interfaces.IFilterException;
import com.topsail.crm.order.framework.harley.interfaces.IFilterIn;
import com.topsail.crm.order.framework.harley.interfaces.IFilterOut;

import java.util.List;

/**
 * @program: crm-V0
 * @description: 过滤器工厂类，负责根据条件获取适合的过滤器供处理
 * @author: jinnian
 * @create: 2020-01-19 15:45
 **/
public class FilterFactory {

    public static List<IFilterIn> getServiceInFitlers() throws Exception {
        return null;
    }

    public static List<IFilterOut> getServiceOutFilters() throws Exception {
        return null;
    }

    public static List<IFilterException> getServiceExceptionFilters() throws Exception {
        return null;
    }

}
