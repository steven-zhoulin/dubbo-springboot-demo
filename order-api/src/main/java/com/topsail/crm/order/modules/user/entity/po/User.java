package com.topsail.crm.order.modules.user.entity.po;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Steven
 * @date 2019-12-16
 */
@Data
@Builder
@EqualsAndHashCode
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Integer age;
}
