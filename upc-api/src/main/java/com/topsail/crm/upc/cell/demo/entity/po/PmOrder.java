package com.topsail.crm.upc.cell.demo.entity.po;

import com.asiainfo.areca.framework.data.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>
 * the modifycation of every operation on the web page will recorded in this table.
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
@TableName("PM_ORDER")
public class PmOrder extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ORDER_ID
     */
    @TableId("ORDER_ID")
    private Long orderId;

    /**
     * ORDER_TYPE:ORDER_DEFFor offering:ORDER_WAREFor Product:ORDER_PRODUCTFor Price:ORDER_PRICEFor Tag:ORDER_TAGFor Attribute:ORDER_FEATURE
     */
    @TableField("ORDER_TYPE")
    private String orderType;

    /**
     * 0: Not Need Audit1: Need Audit
     */
    @TableField("AUDIT_TAG")
    private String auditTag;

    /**
     * 0:Init1:Pass2:Refuse
     */
    @TableField("STATUS")
    private String status;

    /**
     * ACCEPT_MONTH
     */
    @TableField("ACCEPT_MONTH")
    private Integer acceptMonth;

    /**
     * DONE_CODE
     */
    @TableField("DONE_CODE")
    private Long doneCode;

    /**
     * CREATE_DATE
     */
    @TableField("CREATE_DATE")
    private LocalDateTime createDate;

    /**
     * DONE_DATE
     */
    @TableField("DONE_DATE")
    private LocalDateTime doneDate;

    /**
     * OP_ID
     */
    @TableField("OP_ID")
    private String opId;

    /**
     * ORG_ID
     */
    @TableField("ORG_ID")
    private String orgId;

    /**
     * REMARK
     */
    @TableField("REMARK")
    private String remark;


}
