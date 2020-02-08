package com.topsail.crm.order.cell.order.entity.dto;

import com.topsail.crm.order.annotation.BusiItemCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @program: crm
 * @description: 创建用户密码变更订单数据传输对象
 * @author: jinnian
 * @create: 2020-01-19 17:49
 **/
@Data
@EqualsAndHashCode(callSuper=false)
public class ChangePasswordRequestDTO extends UserRequestDTO {
    private String newPassword;

    private String oldPassword;
}
