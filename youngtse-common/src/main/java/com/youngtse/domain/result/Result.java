package com.youngtse.domain.result;
import com.youngtse.enums.BaseResultEnum;
import com.youngtse.enums.common.CommonResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Youngtse
 * @title Result
 * @date 2023/4/28 14:38
 * @description TODO
 */
@Data
@ApiModel(value = "Result 通用返回")
public class Result<T> implements Serializable {

    @ApiModelProperty("请求状态 true:成功,false:失败")
    private boolean status;
    @ApiModelProperty("响应码")
    private String code;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("响应结果")
    private T data;

    private Result() {
    }

    public static Result success () {
        return build(true, BaseResultEnum.SUCCESS.getCode(), BaseResultEnum.SUCCESS.getMessage(), null);
    }

    public static Result success (Object data) {
        return build(true, BaseResultEnum.SUCCESS.getCode(), BaseResultEnum.SUCCESS.getMessage(), data);
    }

    public static Result success (CommonResultEnum commonResultEnum, Object data) {
        return build(true, commonResultEnum.getCode(), commonResultEnum.getMessage(), data);
    }

    public static Result fail () {
        return build(false, BaseResultEnum.FAIL.getCode(), BaseResultEnum.FAIL.getMessage(), null);
    }

    public static Result fail (Object data) {
        return build(false, BaseResultEnum.FAIL.getCode(), BaseResultEnum.FAIL.getMessage(), data);
    }

    public static Result fail (CommonResultEnum commonResultEnum) {
        return build(false, commonResultEnum.getCode(), commonResultEnum.getMessage(), null);
    }

    public static Result fail (CommonResultEnum commonResultEnum, Object data) {
        return build(false, commonResultEnum.getCode(), commonResultEnum.getMessage(), data);
    }

    public static Result fail (String message) {
        return build(false, BaseResultEnum.FAIL.getCode(), message, null);
    }

    public static Result fail (String code, String message) {
        return build(false, code, message, null);
    }

    private static Result build(boolean status, String code, String message, Object data) {
        Result result = new Result<>();
        result.setStatus(status);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
