package com.youngtse.common.exception;

import com.youngtse.common.enums.BaseResultEnum;
import com.youngtse.common.enums.common.CommonResultEnum;
import lombok.Getter;

/**
 * @author Youngtse
 * @title BusinessException
 * @date 2023/4/28 15:55
 */
@Getter
public class BusinessException extends RuntimeException{

    private String code;

    private String message;

    public BusinessException() {
        this.code = BaseResultEnum.ERROR.getCode();
        this.message = BaseResultEnum.ERROR.getMessage();
    }

    public BusinessException(String message) {
        this.code = BaseResultEnum.ERROR.getCode();
        this.message = message;
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(CommonResultEnum commonResultEnum) {
        this.code = commonResultEnum.getCode();
        this.message = commonResultEnum.getMessage();
    }

}
