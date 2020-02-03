package com.topsail.crm.order.framework.harley.interfaces;

import com.topsail.crm.order.framework.harley.context.JobContext;

/**
 * @program: crm-jzh
 * @description: ${description}
 * @author: jinnian
 * @create: 2019-05-24 11:37
 **/
public interface IProcessor {

    void process(JobContext jobContext);
}
