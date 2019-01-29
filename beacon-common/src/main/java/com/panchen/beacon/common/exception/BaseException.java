package com.panchen.beacon.common.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -3350993178244762078L;

    private String code;

    private String message;

    private Object data;

    private BaseException(BaseErrorEnum baseErrorEnum) {
        this.code = baseErrorEnum.getCode();
        this.message = baseErrorEnum.getMessage();
    }

    private BaseException(BaseErrorEnum baseErrorEnum, Object data) {
        this(baseErrorEnum);
        this.data = data;
    }
}
