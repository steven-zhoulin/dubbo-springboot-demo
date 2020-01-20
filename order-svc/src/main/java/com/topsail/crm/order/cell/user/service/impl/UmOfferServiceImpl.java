package com.topsail.crm.order.cell.user.service.impl;

import com.topsail.crm.order.cell.user.entity.po.UmOffer;
import com.topsail.crm.order.cell.user.mapper.UmOfferMapper;
import com.topsail.crm.order.cell.user.service.IUmOfferService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Slf4j
@Component
@Service
public class UmOfferServiceImpl extends ServiceImpl<UmOfferMapper, UmOffer> implements IUmOfferService {

}
