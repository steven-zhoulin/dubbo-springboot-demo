package com.topsail.crm.order.framework.harley.runtime;


import com.asiainfo.areca.framework.util.TimeUtils;
import com.topsail.crm.order.cell.order.entity.po.OmLine;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: crm-V0
 * @description: 基础的业务处理类，负责生成订单行的基础数据
 * @author: jinnian
 * @create: 2020-01-18 01:07
 **/
@Slf4j
public class BaseProcessor implements IProcessor {

    @Override
    public void process(JobContext jobContext) {
        long start = System.currentTimeMillis();
        if (log.isInfoEnabled()) {
            log.info("**************************核心处理类处理开始**************************");
        }

        this.processLine(jobContext);

        this.processItem(jobContext);

        long end = System.currentTimeMillis();
        if (log.isInfoEnabled()) {
            log.info("**************************核心处理类处理结束**************************");
            log.info("核心处理类耗时：" + (end-start) + "ms");
        }
    }

    public void processLine(JobContext jobContext) {
        OmLine line = jobContext.getLineData().getLine();
        ScaKernel sca = jobContext.getSca();
        Databus databus = DatabusManager.getDatabus();
        Long orderLineId = new Long(20200120);

        line.setPartitionId(1);
        line.setOrderLineId(orderLineId);
        line.setBusiItemCode(jobContext.getUserRequest().getBusiItemCode());
        line.setPriority(0);
        if (sca != null) {
            line.setSubscriberInsId(sca.getSubscriberInsId());
            line.setPartyRoleId(sca.getCustId());
            line.setAccessNum(sca.getAccessNum());
            line.setMgmtDistrict(sca.getMgmtDistrict());
            line.setMgmtCounty(sca.getSubscriber().getMgmtCounty());
        } else {
            line.setSubscriberInsId(new Long(1));
            line.setPartyRoleId(new Long(1));
            line.setAccessNum("-1");
        }

        line.setOrderStatus("0");
        line.setDataStatus("1");
        line.setOmItemId(1L);
    }

    /**
     * 如果有订单子项，由子类重写此方法
     * @param jobContext
     * @throws Exception
     */
    public void processItem(JobContext jobContext) {
        //由子类重写
    }
}
