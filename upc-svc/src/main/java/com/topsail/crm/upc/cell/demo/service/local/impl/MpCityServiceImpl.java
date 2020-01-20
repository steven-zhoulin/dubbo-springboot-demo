package com.topsail.crm.upc.cell.demo.service.local.impl;

import com.topsail.crm.upc.cell.demo.entity.po.MpCity;
import com.topsail.crm.upc.cell.demo.mapper.MpCityMapper;
import com.topsail.crm.upc.cell.demo.service.local.IMpCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Steven.zhou
 * @since 2020-01-10
 */
@Slf4j
@Component
@Service
public class MpCityServiceImpl extends ServiceImpl<MpCityMapper, MpCity> implements IMpCityService {

}
