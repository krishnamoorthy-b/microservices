package com.krishnaedu.edu_identity.exception;

public class BusinessException extends Exception {

    public BusinessException(String errMsg, Throwable t) {
        super(errMsg,t);
    }

    public BusinessException(String errMsg) {
        super(errMsg);
    }
}
