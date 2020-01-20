package com.topsail.crm.upc.cell.demo.entity.po;

import com.asiainfo.areca.framework.data.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author Steven.zhou
 * @since 2020-01-10
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("MP_CITY")
public class MpCity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableField("ID")
    private Long id;

    /**
     * 城市名
     */
    @TableField("NAME")
    private String name;

    @TableField("PROVINCE_ID")
    private Long provinceId;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 1：有效，0：失效
     */
    @TableField("ENABLED")
    private String enabled;


}
