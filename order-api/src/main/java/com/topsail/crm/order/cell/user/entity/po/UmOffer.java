package com.topsail.crm.order.cell.user.entity.po;

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
@TableName("UM_OFFER")
public class UmOffer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("OFFER_INS_ID")
    private Long offerInsId;

    @TableField("CUST_ID")
    private Long custId;

    @TableField("SUBSCRIBER_INS_ID")
    private Long subscriberInsId;

    @TableField("BRAND")
    private String brand;

    @TableField("OFFER_ID")
    private Long offerId;

    @TableField("OFFER_NAME")
    private String offerName;

    @TableField("OFFER_TYPE")
    private String offerType;

    @TableField("IS_BUNDLE")
    private String isBundle;

    @TableField("IS_MAIN")
    private String isMain;

    @TableField("IS_ROOT")
    private String isRoot;

    @TableField("SRC_SYSTEM_TYPE")
    private Integer srcSystemType;

    @TableField("FIRST_DATE_MON")
    private LocalDateTime firstDateMon;

    @TableField("REMARKS")
    private String remarks;

    @TableField("VALID_TYPE")
    private String validType;

    @TableField("EXPIRE_TYPE")
    private String expireType;

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

    @TableField("BIZ_TYPE")
    private Long bizType;

    @TableField("MAIN_OFFER_ID")
    private Long mainOfferId;

    @TableField("REL_SUBSCRIBER_INS_ID")
    private Long relSubscriberInsId;

    @TableField("MAIN_OFFER_TYPE")
    private String mainOfferType;

    @TableField("ORDER_LINE_ID")
    private Long orderLineId;


}
