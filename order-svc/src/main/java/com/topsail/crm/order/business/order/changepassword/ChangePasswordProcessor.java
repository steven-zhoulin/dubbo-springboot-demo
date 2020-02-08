package com.topsail.crm.order.business.order.changepassword;

import com.topsail.crm.order.cell.order.entity.dto.ChangePasswordRequestDTO;
import com.topsail.crm.order.cell.order.entity.po.OmSubscriber;
import com.topsail.crm.order.framework.harley.annotation.Processor;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;
import com.topsail.crm.order.framework.harley.interfaces.IProcessor;
import com.topsail.crm.order.framework.harley.runtime.BaseProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * @program: crm
 * @description: 用户密码变更业务订单核心处理类
 * @author: jinnian
 * @create: 2020-01-20 14:40
 **/
@Processor(busiItemCode = "110", dto=ChangePasswordRequestDTO.class)
@Slf4j
public class ChangePasswordProcessor extends BaseProcessor implements IProcessor {

    @Override
    public void processItem(JobContext jobContext) {
        log.info("-------------业务processor开始处理---------------------");
        ScaKernel sca = jobContext.getSca();
        ChangePasswordRequestDTO changePasswordDTO = (ChangePasswordRequestDTO)jobContext.getUserRequest();
        OmSubscriber omSubscriber = new OmSubscriber();
        BeanUtils.copyProperties(sca.getSubscriber(), omSubscriber);
        omSubscriber.setPassword(changePasswordDTO.getNewPassword());
        omSubscriber.setAction(2);
        omSubscriber.setDoneDate(null);

        jobContext.add(omSubscriber);
    }
}
