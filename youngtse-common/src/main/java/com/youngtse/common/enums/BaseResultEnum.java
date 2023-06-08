package com.youngtse.common.enums;

import com.youngtse.common.enums.common.CommonResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Youngtse
 * @title BaseResultEnum
 * @date 2023/4/28 15:01
 * @description TODO
 */
@AllArgsConstructor
@Getter
public enum BaseResultEnum implements CommonResultEnum {
    SUCCESS("0", "处理成功"),
    FAIL("-1", "处理失败"),
    ERROR("-1", "系统异常"),
    REQUEST_METHOD_ERROR("2000", "请求方法错误");
    ;

    private String code;

    private String message;

}
