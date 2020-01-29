package com.topsail.crm.upc.cell.demo.service.local.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.topsail.crm.upc.cell.demo.entity.po.PmOrder;
import com.topsail.crm.upc.cell.demo.mapper.PmOrderMapper;
import com.topsail.crm.upc.cell.demo.service.local.IPmOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 * the modifycation of every operation on the web page will recorded in this table. 服务实现类
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Slf4j
@Component
//@Service
public class PmOrderServiceImpl extends ServiceImpl<PmOrderMapper, PmOrder> implements IPmOrderService {

}
