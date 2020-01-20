package com.topsail.crm.order.cell.order.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.asiainfo.areca.framework.data.BaseEntity;
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
@TableName("OM_LINE")
public class OmLine extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("DAY")
    private Integer day;

    @TableField("PARTITION_ID")
    private Integer partitionId;

    @TableField("ORDER_LINE_ID")
    private Long orderLineId;

    @TableField("ORDER_ID")
    private Long orderId;

    @TableField("INTACT_ID")
    private Long intactId;

    @TableField("SPEC_ID")
    private Long specId;

    @TableField("IN_MODE_CODE")
    private String inModeCode;

    @TableField("ORDER_LINE_TYPE")
    private String orderLineType;

    @TableField("PARTY_ROLE_ID")
    private Long partyRoleId;

    @TableField("ACCT_ID")
    private Long acctId;

    @TableField("SUBSCRIBER_INS_ID")
    private Long subscriberInsId;

    @TableField("BUSI_ITEM_CODE")
    private String busiItemCode;

    @TableField("ACCESS_NUM")
    private String accessNum;

    @TableField("PRIORITY")
    private Integer priority;

    @TableField("VERIFY_TYPE")
    private String verifyType;

    @TableField("PROCESS_ID")
    private String processId;

    @TableField("REVISION_NUMBER")
    private String revisionNumber;

    @TableField("ORDER_STATUS")
    private String orderStatus;

    @TableField("EXEC_DATE")
    private LocalDateTime execDate;

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

    @TableField("TRADE_MGMT_DISTRICT")
    private String tradeMgmtDistrict;

    @TableField("TRADE_MGMT_COUNTY")
    private String tradeMgmtCounty;

    @TableField("MGMT_DISTRICT")
    private String mgmtDistrict;

    @TableField("MGMT_COUNTY")
    private String mgmtCounty;

    @TableField("REGION_ID")
    private String regionId;

    @TableField("INTF_ID")
    private String intfId;

    @TableField("PF_SEND")
    private String pfSend;

    @TableField("PF_WAIT")
    private String pfWait;

    @TableField("CANCEL_TAG")
    private String cancelTag;

    @TableField("CANCEL_LINE_ID")
    private String cancelLineId;

    @TableField("CANCEL_DATE")
    private LocalDateTime cancelDate;

    @TableField("CANCEL_OP_ID")
    private String cancelOpId;

    @TableField("CANCEL_ORG_ID")
    private String cancelOrgId;

    @TableField("CANCEL_REASON")
    private String cancelReason;

    @TableField("REMARKS")
    private String remarks;

    @TableField("GROUP_ID")
    private Long groupId;

    @TableField("OM_ITEM_ID")
    private Long omItemId;

    @TableField("RL_NUMBER")
    private String rlNumber;

    @TableField("RL_BUSI_HALL_ID")
    private String rlBusiHallId;

    @TableField("RL_ORG_ID")
    private String rlOrgId;

    @TableField("BVS_DEVICE_ID")
    private String bvsDeviceId;

    @TableField("STAGE_FLAG")
    private String stageFlag;


}
