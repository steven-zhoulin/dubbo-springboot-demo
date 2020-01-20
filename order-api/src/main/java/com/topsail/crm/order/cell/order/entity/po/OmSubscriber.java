package com.topsail.crm.order.cell.order.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.asiainfo.areca.framework.data.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>
 * OmItemOfSubscriber
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
@TableName("OM_SUBSCRIBER")
public class OmSubscriber extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ORDER_LINE_ID
     */
    @TableField("ORDER_LINE_ID")
    private Long orderLineId;

    /**
     * ORDER_ID
     */
    @TableField("ORDER_ID")
    private Long orderId;

    /**
     * 用户实例标识
     */
    @TableField("SUBSCRIBER_INS_ID")
    private Long subscriberInsId;

    /**
     * 客户标识
     */
    @TableField("CUST_ID")
    private Long custId;

    /**
     * 产品实例标识
     */
    @TableField("PROD_INS_ID")
    private Long prodInsId;

    /**
     * 产品线标识
     */
    @TableField("PROD_LINE_ID")
    private Long prodLineId;

    /**
     * 产品线名称
     */
    @TableField("PROD_LINE_NAME")
    private String prodLineName;

    /**
     * 用户类别1--GSM用户4--IPBUS使用用户8--集团用户18--WLAN用户19--宽带用户22--个人群组用户25--固话用户35--物联网用户36--农村CPE用户
     */
    @TableField("SUBSCRIBER_TYPE")
    private String subscriberType;

    /**
     * 用户星级49--未评级（经分系统）50--零星级51--一星级52--二星级53--三星级54--四星级55--五星级56--五星金57--五星钻60--未评级（营业系统）
     */
    @TableField("SUBSCRIBER_LEVEL")
    private String subscriberLevel;

    /**
     * 是否4GSIM卡用户0--否1--是
     */
    @TableField("IS_USIM")
    private String isUsim;

    /**
     * 接入号
     */
    @TableField("ACCESS_NUM")
    private String accessNum;

    /**
     * 密码类型
     */
    @TableField("PASSWORD_TYPE")
    private Integer passwordType;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 次计费标识
     */
    @TableField("SUB_BILL_ID")
    private String subBillId;

    /**
     * 出帐标志0--正常处理1--定时激活2--待激活用户Z--不出帐
     */
    @TableField("ACCT_TAG")
    private String acctTag;

    /**
     * 固定费用重算标志0--不重算1--重算2--从月初开始重算
     */
    @TableField("MPUTE_TAG")
    private String mputeTag;

    /**
     * 首次激活时间
     */
    @TableField("FIRST_ACTIVE_DATE")
    private LocalDateTime firstActiveDate;

    /**
     * 注销原因
     */
    @TableField("REMOVE_REASON")
    private String removeReason;

    /**
     * 预销时间
     */
    @TableField("PRE_DESTORY_DATE")
    private LocalDateTime preDestoryDate;

    /**
     * 销户时间
     */
    @TableField("DESTORY_DATE")
    private LocalDateTime destoryDate;

    /**
     * 开户方式0--正常1--预开未返单2--预开已返单3--过户新增4--当日返单并过户
     */
    @TableField("OPEN_MODE")
    private String openMode;

    /**
     * 开户时间
     */
    @TableField("OPEN_DATE")
    private LocalDateTime openDate;

    /**
     * 用户状态0--历史1--正常2--营业预销3--帐务预销4--营业销户5--帐务销户6--管理预销7--管理销户8--实名制销户10--待激活
     */
    @TableField("SUBSCRIBER_STATUS")
    private String subscriberStatus;

    /**
     * 区号
     */
    @TableField("AREA_CODE")
    private String areaCode;

    /**
     * 催缴方式1--免催缴2--语音催缴3--短信催缴4--语音+短信催缴5--邮寄催缴6--上门服务
     */
    @TableField("PROMPT_TYPE")
    private String promptType;

    /**
     * 催缴号码
     */
    @TableField("PROMPT_NBR")
    private String promptNbr;

    /**
     * 催缴语言0--无1--地方语言2--普通话3--英语4--日语
     */
    @TableField("PROMPT_LAG")
    private String promptLag;

    /**
     * 备注
     */
    @TableField("REMARKS")
    private String remarks;

    /**
     * ACTION
     */
    @TableField("ACTION")
    private Integer action;

    /**
     * 数据状态0--无效1--有效
     */
    @TableField("DATA_STATUS")
    private String dataStatus;

    /**
     * 事务编号
     */
    @TableField("DONE_CODE")
    private Long doneCode;

    /**
     * 创建日期
     */
    @TableField("CREATE_DATE")
    private LocalDateTime createDate;

    /**
     * 创建操作员编码
     */
    @TableField("CREATE_OP_ID")
    private String createOpId;

    /**
     * 创建组织编码
     */
    @TableField("CREATE_ORG_ID")
    private String createOrgId;

    /**
     * 创建操作员归属地区开户时：需要填写该字段，填写操作员地区。数据割接：已经携号跨区的用户需要根据号码的号段填写用户号码归属地区携号跨区时：只修改用户管理地区和县市，不修改CREATE_DISTRICT .
     */
    @TableField("CREATE_DISTRICT")
    private String createDistrict;

    /**
     * 操作日期
     */
    @TableField("DONE_DATE")
    private LocalDateTime doneDate;

    /**
     * 操作员编码
     */
    @TableField("OP_ID")
    private String opId;

    /**
     * 操作组织编码
     */
    @TableField("ORG_ID")
    private String orgId;

    /**
     * 管理地区
     */
    @TableField("MGMT_DISTRICT")
    private String mgmtDistrict;

    /**
     * 管理县市
     */
    @TableField("MGMT_COUNTY")
    private String mgmtCounty;

    /**
     * 数据归属地区
     */
    @TableField("REGION_ID")
    private String regionId;

    /**
     * 账单类型：1后付费,2预付费
     */
    @TableField("BILL_TYPE")
    private Integer billType;

    /**
     * 首次停机时间
     */
    @TableField("FIRST_STOP_TIME")
    private LocalDateTime firstStopTime;

    /**
     * OS_STS
     */
    @TableField("OS_STS")
    private String osSts;

    /**
     * 销户时主产品id，销户时记录，用于复机
     */
    @TableField("LAST_OFFER_ID")
    private Long lastOfferId;

    /**
     * OM_ITEM_ID
     */
    @TableId("OM_ITEM_ID")
    private Long omItemId;

    /**
     * MNP_FLAG
     */
    @TableField("MNP_FLAG")
    private Integer mnpFlag;


}
