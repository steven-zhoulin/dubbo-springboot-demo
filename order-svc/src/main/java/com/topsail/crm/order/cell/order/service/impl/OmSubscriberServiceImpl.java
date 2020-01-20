package com.topsail.crm.order.cell.order.service.impl;

import com.topsail.crm.order.cell.order.entity.po.OmSubscriber;
import com.topsail.crm.order.cell.order.mapper.OmSubscriberMapper;
import com.topsail.crm.order.cell.order.service.IOmSubscriberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * OmItemOfSubscriber 服务实现类
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Slf4j
@Component
@Service
public class OmSubscriberServiceImpl extends ServiceImpl<OmSubscriberMapper, OmSubscriber> implements IOmSubscriberService {

}
