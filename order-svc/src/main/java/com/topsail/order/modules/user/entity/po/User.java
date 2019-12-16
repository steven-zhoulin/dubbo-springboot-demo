package com.topsail.order.modules.user.entity.po;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Data
@Builder
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
}
