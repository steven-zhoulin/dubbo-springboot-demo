package com.topsail.crm.order.cell.order.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: crm
 * @description: 基础订单创建传输对象<br/>
 *               内部包含用户请求对象
 * @author: jinnian
 * @create: 2020-01-19 17:14
 **/
@Data
public class OrderRequestDTO {

    /**
     * 场景类型 0-正常(默认)
     */
    private String sceneType;

    /**
     * 用户请求（适用于多用户的场景）
     */
    private List<UserRequestDTO> userRequests;
}
