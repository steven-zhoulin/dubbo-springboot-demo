package com.topsail.crm.order.cell.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用来返回订单信息
 * <p>
 * liaosheng@asiainfo.com
 * 2020/1/29 3:13 下午
 */
@Data
@NoArgsConstructor
@Component
public class OrderDTO {

    @JsonProperty("USER_ID")
    private Long userId;

    @JsonProperty("ORDER_ID")
    private String orderId;

    @JsonProperty("LINE_IDS")
    private String[] lines;
}
