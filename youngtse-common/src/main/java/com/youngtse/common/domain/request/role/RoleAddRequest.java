package com.youngtse.common.domain.request.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author Youngtse
 * @title AddRoleRequest
 * @date 2023/6/9 14:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("新增角色参数")
public class RoleAddRequest {

    @ApiModelProperty(value = "角色", notes = "英文小写", required = true)
    @NotEmpty(message = "角色不能为空")
    @Pattern(regexp = "[a-z]*", message = "角色格式错误")
    private String roleSubject;

    @NotEmpty(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称", required = true)
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleRemark;

    @NotNull(message = "角色是否可以不能为空")
    @Max(value = 1, message = "是否可用不能为0或1之外的值")
    @Min(value = 0, message = "是否可用不能为0或1之外的值")
    @ApiModelProperty(value = "是否可用:0不可用,1可用", allowableValues = "0,1", required = true)
    private Integer enabled;
}
