package com.topsail.crm.order.cell.demo.interfaces;

import com.topsail.crm.order.cell.demo.entity.po.Steven;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Steven
 * @date 2020-02-08
 */
public interface IStevenCSV {
    @ApiOperation("创建实例数据")
    @PostMapping("/createOrder")
    Long createOrder(@RequestBody Steven steven);

    @ApiOperation("根据Id查订单数据")
    @GetMapping("/queryOrder/{id}")
    Steven queryOrder(@PathVariable("id") Long id);

    @ApiOperation("根据 Id 逻辑删除订单")
    @GetMapping("/deleteOrder/{id}")
    void deleteOrder(@PathVariable("id") Long id);

    void updateOrder(@RequestBody Steven steven);
}
