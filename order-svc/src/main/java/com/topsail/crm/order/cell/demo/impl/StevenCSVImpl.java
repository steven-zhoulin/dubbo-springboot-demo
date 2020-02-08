package com.topsail.crm.order.cell.demo.impl;

import com.asiainfo.areca.framework.database.service.IDualService;
import com.asiainfo.areca.framework.threadlocal.RequestTimeHolder;
import com.topsail.crm.order.cell.demo.entity.po.Steven;
import com.topsail.crm.order.cell.demo.interfaces.IStevenCSV;
import com.topsail.crm.order.cell.demo.service.IStevenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;

/**
 * @author Steven
 * @date 2020-02-08
 */
@Api("Demo服务")
@Slf4j
@RestController
@RequestMapping("/api/demo/steven")
public class StevenCSVImpl implements IStevenCSV {

    @Autowired
    private IStevenService stevenService;

    @Autowired
    private IDualService dualService;

    @ApiOperation("创建实例数据")
    @PostMapping("/createOrder")
    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public Long createOrder(@RequestBody Steven steven) {

        Steven one = stevenService.getById(1L);
        log.info("one: {}", one);

        log.info("user info {}", steven);
        Long nextval = dualService.nextval("crm1", "OM_ORDER$SEQ");
        log.info("nextval: {}", nextval);

        String idStr = RequestTimeHolder.getRequestTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + nextval;
        Long id = Long.parseLong(idStr);
        log.info("id: {}", id);

        steven.setId(id);
        stevenService.save(steven);
        return steven.getId();
    }


}
