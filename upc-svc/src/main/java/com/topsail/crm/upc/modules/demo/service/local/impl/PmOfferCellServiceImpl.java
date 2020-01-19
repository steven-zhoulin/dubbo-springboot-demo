package com.topsail.crm.upc.modules.demo.service.local.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.topsail.crm.upc.modules.demo.entity.po.PmOfferCell;
import com.topsail.crm.upc.modules.demo.mapper.PmOfferCellMapper;
import com.topsail.crm.upc.modules.demo.service.local.IPmOfferCellService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * <p>
 * describe relationship between offering and base station group 服务实现类
 * </p>
 *
 * @author Steven
 * @since 2020-01-10
 */
@Slf4j
@Component
@Service
public class PmOfferCellServiceImpl extends ServiceImpl<PmOfferCellMapper, PmOfferCell> implements IPmOfferCellService {

}