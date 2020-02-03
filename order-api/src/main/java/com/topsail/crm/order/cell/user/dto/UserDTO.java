package com.topsail.crm.order.cell.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户信息
 * <p>
 * liaosheng@asiainfo.com
 * 2020/1/29 3:15 下午
 */
@Data
@NoArgsConstructor
@Component
public class UserDTO {

    @JsonProperty("USER_ID")
    private Long userId;

    @JsonProperty("ACCESS_NUM")
    private String accessNum;

    @JsonProperty("USER_PSWD")
    private String password;
}
