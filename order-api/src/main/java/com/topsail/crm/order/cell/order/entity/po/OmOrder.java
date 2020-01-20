package com.topsail.crm.order.cell.order.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.asiainfo.areca.framework.data.BaseEntity;
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
@TableName("OM_ORDER")
public class OmOrder extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("DAY")
    private Integer day;

    @TableField("PARTITION_ID")
    private Integer partitionId;

    @TableId("ORDER_ID")
    private Long orderId;

    @TableField("PROCESS_ID")
    private String processId;

    @TableField("PARTY_ROLE_ID")
    private Long partyRoleId;

    @TableField("BUSI_CODE")
    private String busiCode;

    @TableField("IN_MODE_CODE")
    private String inModeCode;

    @TableField("APPLY_CHANNEL")
    private String applyChannel;

    @TableField("IN_ORDER_ID")
    private String inOrderId;

    @TableField("PRIORITY")
    private Integer priority;

    @TableField("PARTY_NAME")
    private String partyName;

    @TableField("ORDER_TYPE")
    private String orderType;

    @TableField("CANCEL_ORDER_ID")
    private Long cancelOrderId;

    @TableField("CANCEL_REASON")
    private String cancelReason;

    @TableField("CANCEL_FLAG")
    private String cancelFlag;

    @TableField("OPERATOR_MODE")
    private String operatorMode;

    @TableField("OPERATOR_NAME")
    private String operatorName;

    @TableField("OPERATOR_IDEN_TYPE")
    private String operatorIdenType;

    @TableField("OPERATOR_IDEN_NR")
    private String operatorIdenNr;

    @TableField("OPERATOR_ADDRESS")
    private String operatorAddress;

    @TableField("OPERATOR_NUMBER")
    private String operatorNumber;

    @TableField("OPERATOR_EMAIL")
    private String operatorEmail;

    @TableField("OPERATOR_DISTRICT")
    private String operatorDistrict;

    @TableField("OPERATOR_DESC")
    private String operatorDesc;

    @TableField("REMARKS")
    private String remarks;

    @TableField("BATCH_ID")
    private Long batchId;

    @TableField("REVISION_NUMBER")
    private String revisionNumber;

    @TableField("ORDER_STATUS")
    private String orderStatus;

    @TableField("VALID_DATE")
    private LocalDateTime validDate;

    @TableField("EXPIRE_DATE")
    private LocalDateTime expireDate;

    @TableField("DATA_STATUS")
    private String dataStatus;

    @TableField("DONE_CODE")
    private Long doneCode;

    @TableField("CREATE_DATE")
    private LocalDateTime createDate;

    @TableField("CREATE_OP_ID")
    private String createOpId;

    @TableField("CREATE_ORG_ID")
    private String createOrgId;

    @TableField("DONE_DATE")
    private LocalDateTime doneDate;

    @TableField("OP_ID")
    private String opId;

    @TableField("ORG_ID")
    private String orgId;

    @TableField("MGMT_DISTRICT")
    private String mgmtDistrict;

    @TableField("MGMT_COUNTY")
    private String mgmtCounty;

    @TableField("REGION_ID")
    private String regionId;

    @TableField("CANCEL_TAG")
    private String cancelTag;

    @TableField("OM_ITEM_ID")
    private Long omItemId;

    @TableField("IS_DIFF")
    private String isDiff;

    @TableField("EXEC_DATE")
    private LocalDateTime execDate;


}
