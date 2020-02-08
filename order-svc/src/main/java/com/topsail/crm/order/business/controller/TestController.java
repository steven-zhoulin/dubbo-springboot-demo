package com.topsail.crm.order.business.controller;

import com.asiainfo.areca.framework.annotation.RestResult;
import com.topsail.crm.order.business.order.ISubscriberOrderService;
import com.topsail.crm.order.cell.order.entity.dto.ChangePasswordRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.cell.order.entity.dto.UserRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: crm
 * @description: 测试类
 * @author: jinnian
 * @create: 2020-01-20 16:05
 **/
@RestController
@Slf4j
@RequestMapping("/api/test/subscriber")
public class TestController {

    @Autowired
    private ISubscriberOrderService subscriberOrderService;

    @RequestMapping("/changepassword")
    @RestResult
    public OrderResponseDTO testChangePassword() {
        OrderRequestDTO request = new OrderRequestDTO();
        ChangePasswordRequestDTO userRequest = new ChangePasswordRequestDTO();
        userRequest.setAccessNum("13723885094");
        userRequest.setNewPassword("654321");

        List<UserRequestDTO> userRequestDTOS = new ArrayList<UserRequestDTO>();
        userRequestDTOS.add(userRequest);
        request.setUserRequests(userRequestDTOS);

        return this.subscriberOrderService.changePassword(request);
    }
}
