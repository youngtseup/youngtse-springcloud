package com.youngtse.common.domain.request.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author Youngtse
 * @title SystemRole
 * @date 2023/6/8 14:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("修改角色参数")
public class UpdateRoleRequest {

    @ApiModelProperty(value = "角色id", required = true)
    @NotEmpty(message = "角色id不能空")
    private Integer roleId;

    @ApiModelProperty(value = "角色", notes = "英文小写")
    @Pattern(regexp = "[a-z]*", message = "角色格式错误")
    private String roleSubject;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleRemark;

    @Max(value = 1, message = "是否可用不能为0或1之外的值")
    @Min(value = 0, message = "是否可用不能为0或1之外的值")
    @ApiModelProperty(value = "是否可用:0不可用,1可用", allowableValues = "0,1")
    private Integer enabled;

}
