package com.topsail.crm.order.framework.harley.interfaces;

import com.topsail.crm.order.framework.harley.context.JobContext;

/**
 * @program: crm-V0
 * @description: 流水线处理插件，在主要程序处理完后执行
 * @author: jinnian
 * @create: 2019-05-24 14:45
 **/
public interface IPlus {

    void execute(JobContext context);
}
