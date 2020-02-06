package com.topsail.crm.order.cell.order.controller.impl;

import com.topsail.crm.order.cell.order.controller.interfaces.IChangePasswdCSV;
import com.topsail.crm.order.cell.order.dto.OrderDTO;
import com.topsail.crm.order.cell.user.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * CSF的服务实现类</br>
 * 1. 查询用户 curl -H "Content-Type: application/json" -X POST -d '{"ACCESS_NUM":100}' "http://127.0.0.1:8080/api/order/changepasswd/queryUser"
 * 2. 生成订单 curl -H "Content-Type: application/json" -X POST -d '{"USER_ID": "123", "ACCESS_NUM":100, "USER_PSWD":1}' "http://127.0.0.1:8080/api/order/changepasswd/createOrder"
 * <p>
 * liaosheng@asiainfo.com
 * 2020/1/29 3:28 下午
 */
@Api("密码变更服务")
@Slf4j
@RestController
@RequestMapping("/api/order/changepasswd")
public class ChangePasswdCSVImpl implements IChangePasswdCSV {

    @ApiOperation("查询用户信息")
    @PostMapping("/queryUser")
    @Override
    public UserDTO queryUser(@RequestBody UserDTO user) {
        log.info("user info {}", user.toString());

        user.setUserId(112233L);
        user.setAccessNum("13787135441");
        return user;
    }

    @ApiOperation("创建订单")
    @PostMapping("/createOrder")
    @Override
    public OrderDTO createOrder(@RequestBody UserDTO user) {
        log.info("user info {}", user.toString());

        OrderDTO order = new OrderDTO();
        order.setUserId(System.currentTimeMillis());
        order.setOrderId("112233");
        order.setLines(new String[] {"112233", "445566"});

        return order;
    }
}
