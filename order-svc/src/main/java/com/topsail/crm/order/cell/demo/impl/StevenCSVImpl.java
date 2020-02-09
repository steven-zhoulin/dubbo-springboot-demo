package com.topsail.crm.order.cell.demo.impl;

import com.asiainfo.areca.framework.annotation.RestResult;
import com.asiainfo.areca.framework.error.Asserts;
import com.topsail.crm.order.cell.demo.DemoError;
import com.topsail.crm.order.cell.demo.entity.po.Steven;
import com.topsail.crm.order.cell.demo.interfaces.IStevenCSV;
import com.topsail.crm.order.cell.demo.service.IStevenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @Override
    @ApiOperation("创建实例数据")
    @PostMapping("/createOrder")
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    @RestResult
    public Long createOrder(@RequestBody Steven steven) {
        steven.setDoneDate(LocalDateTime.now().minusDays(10));
        stevenService.createOrder(steven);
        return steven.getId();
    }

    @Override
    @ApiOperation("根据 Id 逻辑删除订单")
    @GetMapping("/deleteOrder/{id}")
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    @RestResult
    public void deleteOrder(@PathVariable("id") Long id) {
        stevenService.removeById(id);
    }

    @Override
    @ApiOperation("根据Id查订单数据")
    @GetMapping("/queryOrder/{id}")
    @RestResult
    public Steven queryOrder(@PathVariable("id") Long id) {
        return stevenService.getById(id);
    }

    @Override
    @ApiOperation("根据主键进行数据更新")
    @PostMapping("/updateOrder")
    @RestResult
    public void updateOrder(@RequestBody Steven steven) {
        boolean b = stevenService.updateById(steven);
        Asserts.isTrue(b, DemoError.UPDATE_FAILURE);
    }

}
