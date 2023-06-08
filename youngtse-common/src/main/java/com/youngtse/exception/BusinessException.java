package com.youngtse.exception;

import com.youngtse.enums.BaseResultEnum;
import com.youngtse.enums.common.CommonResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author Youngtse
 * @title BusinessException
 * @date 2023/4/28 15:55
 * @description TODO
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
