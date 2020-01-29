package com.topsail.crm.order.cell.demo.service.impl;

import com.topsail.crm.order.cell.demo.entity.po.Steven;
import com.topsail.crm.order.cell.demo.mapper.StevenMapper;
import com.topsail.crm.order.cell.demo.service.IStevenService;
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
public class StevenServiceImpl extends ServiceImpl<StevenMapper, Steven> implements IStevenService {

}
