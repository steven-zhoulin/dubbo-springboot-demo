package com.topsail.crm.order.cell.user.entity.po;

import com.asiainfo.areca.framework.data.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

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
@TableName("UM_SUBSCRIBER")
public class UmSubscriber extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("SUBSCRIBER_INS_ID")
    private Long subscriberInsId;

    @TableField("CUST_ID")
    private Long custId;

    @TableField("PROD_INS_ID")
    private Long prodInsId;

    @TableField("PROD_LINE_ID")
    private Long prodLineId;

    @TableField("PROD_LINE_NAME")
    private String prodLineName;

    @TableField("SUBSCRIBER_TYPE")
    private String subscriberType;

    @TableField("SUBSCRIBER_LEVEL")
    private String subscriberLevel;

    @TableField("IS_USIM")
    private String isUsim;

    @TableField("ACCESS_NUM")
    private String accessNum;

    @TableField("PASSWORD_TYPE")
    private Integer passwordType;

    @TableField("PASSWORD")
    private String password;

    @TableField("SUB_BILL_ID")
    private String subBillId;

    @TableField("ACCT_TAG")
    private String acctTag;

    @TableField("MPUTE_TAG")
    private String mputeTag;

    @TableField("FIRST_ACTIVE_DATE")
    private LocalDateTime firstActiveDate;

    @TableField("REMOVE_REASON")
    private String removeReason;

    @TableField("PRE_DESTORY_DATE")
    private LocalDateTime preDestoryDate;

    @TableField("DESTORY_DATE")
    private LocalDateTime destoryDate;

    @TableField("OPEN_MODE")
    private String openMode;

    @TableField("OPEN_DATE")
    private LocalDateTime openDate;

    @TableField("SUBSCRIBER_STATUS")
    private String subscriberStatus;

    @TableField("AREA_CODE")
    private String areaCode;

    @TableField("PROMPT_TYPE")
    private String promptType;

    @TableField("PROMPT_NBR")
    private String promptNbr;

    @TableField("PROMPT_LAG")
    private String promptLag;

    @TableField("REMARKS")
    private String remarks;

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

    @TableField("CREATE_DISTRICT")
    private String createDistrict;

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

    @TableField("BILL_TYPE")
    private Integer billType;

    @TableField("OS_STS")
    private String osSts;

    @TableField("FIRST_STOP_TIME")
    private LocalDateTime firstStopTime;

    @TableField("LAST_OFFER_ID")
    private Long lastOfferId;

    @TableField("MNP_FLAG")
    private Integer mnpFlag;

    @TableField("ORDER_LINE_ID")
    private Long orderLineId;


}
