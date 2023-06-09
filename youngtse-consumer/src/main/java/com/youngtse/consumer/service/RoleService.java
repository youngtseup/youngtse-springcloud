package com.youngtse.consumer.service;

import com.youngtse.common.domain.entity.SystemRole;
import com.youngtse.common.domain.request.role.AddRoleRequest;
import com.youngtse.common.domain.request.role.QueryRoleRequest;
import com.youngtse.common.domain.request.role.UpdateRoleRequest;
import com.youngtse.common.domain.response.SystemRoleResponse;
import com.youngtse.common.domain.result.Page;

/**
 * @author Youngtse
 * @title RoleService
 * @date 2023/6/9 09:50
 */
public interface RoleService {
    void addSystemRole(AddRoleRequest addRoleRequest);

    void modifyRoleByRoleId(UpdateRoleRequest updateRoleRequest);

    void deleteRoleByRoleId(Integer id);

    Page<SystemRoleResponse> queryList(QueryRoleRequest queryRoleRequest);
}
