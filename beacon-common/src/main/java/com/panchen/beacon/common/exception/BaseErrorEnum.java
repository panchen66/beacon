package com.panchen.beacon.common.exception;

import lombok.Getter;

@Getter
public enum BaseErrorEnum {
    
    COMMON_ERROR("1001","未知异常");
    
    private String code;

    private String message;
    
    private BaseErrorEnum(String code,String message) {
        this.code=code;
        this.message=message;
    }
    
}
