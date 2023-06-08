package com.youngtse.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: RedisKeyValue
 * @Date 2023/4/30 22:04
 * @Author Youngtse
 * @Description: TODO
 */
@ApiModel("Redis key-value")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisKeyValue {
    @ApiModelProperty(value = "key", required = true)
    private String key;
    @ApiModelProperty(value = "value", required = true)
    private String value;
}
