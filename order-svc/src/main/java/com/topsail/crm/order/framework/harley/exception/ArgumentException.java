package com.topsail.crm.order.framework.harley.exception;

import com.asiainfo.areca.framework.exception.BaseException;
import com.asiainfo.areca.framework.exception.Error;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: crm
 * @description: 参数异常类
 * @author: jinnian
 * @create: 2020-01-20 11:18
 **/
@Slf4j
public class ArgumentException extends BaseException {

    public enum ArgumentErrorEnum {
        @Error(code = "ARGUMENT_IS_MUST", message = "必传参数【%s】必传")
        IS_MUST,
    }

    public ArgumentException(ArgumentErrorEnum argumentEnum, String... replaceTexts) {
        try {
            String name = argumentEnum.name();
            Error error = argumentEnum.getClass().getField(name).getAnnotation(Error.class);
            this.setCode(error.code());
            this.setMessage(error.message());
        } catch (Exception e) {
            log.debug("参数注解读取错误", e);
        }
    }
}
