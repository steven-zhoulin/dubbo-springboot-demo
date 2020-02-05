package com.topsail.crm.order.cell.order.controller;

import com.asiainfo.areca.framework.error.Error;
import com.asiainfo.areca.framework.i18n.I18NCode;

/**
 * 模拟定义业务异常
 * <p>
 * liaosheng@asiainfo.com
 * 2020/2/4 12:25 下午
 */
public enum ChangePasswdError implements Error {

    @I18NCode("需要指定手机号码")
    ACCESS_NUM_NOTNULL,

    @I18NCode("手机号码%s不能是数字")
    ACCESS_NUM_NOTNUM
}
