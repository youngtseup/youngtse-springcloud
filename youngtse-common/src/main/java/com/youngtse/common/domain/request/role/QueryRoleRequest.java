package com.youngtse.common.domain.request.role;

import com.youngtse.common.domain.request.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Youngtse
 * @title QueryRoleRequest
 * @date 2023/6/9 14:52
 */
@ApiModel("角色查询参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryRoleRequest extends PageRequest {

    @ApiModelProperty(value = "角色")
    private String roleSubject;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "是否可用:0不可用,1可用")
    private Integer enabled;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

}
