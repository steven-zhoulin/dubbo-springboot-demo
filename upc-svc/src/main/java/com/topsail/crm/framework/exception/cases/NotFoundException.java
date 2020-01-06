package com.topsail.crm.framework.exception.cases;

import com.topsail.crm.framework.exception.BaseException;

/**
 * @author Steven
 */
public class NotFoundException extends BaseException {
    public NotFoundException(String message, int code) {
        super(message, code);
    }
}
