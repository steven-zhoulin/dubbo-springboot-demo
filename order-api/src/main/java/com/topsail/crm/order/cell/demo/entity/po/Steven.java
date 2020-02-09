package com.topsail.crm.order.cell.demo.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.asiainfo.areca.framework.data.BaseEntity;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Steven
 * @since 2020-01-20
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("STEVEN")
public class Steven extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Long id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private Long age;

    @TableField("EMAIL")
    private String email;

    @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableField(value = "DONE_DATE", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime doneDate;

    @TableLogic
    @TableField(value = "DELETED")
    private Boolean deleted;

}
