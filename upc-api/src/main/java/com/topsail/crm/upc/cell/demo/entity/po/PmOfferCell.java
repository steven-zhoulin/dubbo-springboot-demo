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
 * describe relationship between offering and base station group
 * </p>
 *
 * @author Steven
 * @since 2020-01-10
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("PM_OFFER_CELL")
public class PmOfferCell extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * REL_ID
     */
    @TableId("REL_ID")
    private Long relId;

    /**
     * OFFER_ID
     */
    @TableField("OFFER_ID")
    private Long offerId;

    /**
     * CELL_GROUP_CODE
     */
    @TableField("CELL_GROUP_CODE")
    private String cellGroupCode;

    /**
     * REL_TYPE0--convertible1--not convertible
     */
    @TableField("REL_TYPE")
    private Integer relType;

    /**
     * OBJ_ID
     */
    @TableField("OBJ_ID")
    private Integer objId;

    /**
     * DISTRICT_ID
     */
    @TableField("DISTRICT_ID")
    private String districtId;

    /**
     * COUNTY_ID
     */
    @TableField("COUNTY_ID")
    private String countyId;

    /**
     * OUT_PROM
     */
    @TableField("OUT_PROM")
    private Integer outProm;

    /**
     * CELL_TYPE0--base station district1--WLAN district
     */
    @TableField("CELL_TYPE")
    private Integer cellType;

    /**
     * REMARK
     */
    @TableField("REMARK")
    private String remark;

    /**
     * VALID_DATE
     */
    @TableField("VALID_DATE")
    private LocalDateTime validDate;

    /**
     * EXPIRE_DATE
     */
    @TableField("EXPIRE_DATE")
    private LocalDateTime expireDate;

    /**
     * DATA_STATUS0--INVALID1--VALID
     */
    @TableField("DATA_STATUS")
    private String dataStatus;

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
     * CREATE_OP_ID
     */
    @TableField("CREATE_OP_ID")
    private String createOpId;

    /**
     * CREATE_ORG_ID
     */
    @TableField("CREATE_ORG_ID")
    private String createOrgId;

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
     * MGMT_DISTRICT
     */
    @TableField("MGMT_DISTRICT")
    private String mgmtDistrict;

    /**
     * MGMT_COUNTY
     */
    @TableField("MGMT_COUNTY")
    private String mgmtCounty;

    /**
     * REGION_ID
     */
    @TableField("REGION_ID")
    private String regionId;


}
