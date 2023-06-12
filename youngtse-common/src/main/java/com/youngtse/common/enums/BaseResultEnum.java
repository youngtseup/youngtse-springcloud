package com.youngtse.common.enums;

import com.youngtse.common.enums.common.CommonResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Youngtse
 * @title BaseResultEnum
 * @date 2023/4/28 15:01
 */
@AllArgsConstructor
@Getter
public enum BaseResultEnum implements CommonResultEnum {
    SUCCESS("0", "处理成功"),
    FAIL("-1", "处理失败"),
    ERROR("-1", "系统异常"),
    REQUEST_METHOD_ERROR("2000", "请求方法错误"),
    PARAM_ERROR("2001", "参数错误"),
    RECODE_NOT_EXIST("2002", "记录不存在"),
    DECRYPT_ERROR("2003", "解密失败"),
    MENU_PID_EXIST("2004", "该菜单存在对应的子菜单，请先删除子菜单")
    ;

    private String code;

    private String message;

}
