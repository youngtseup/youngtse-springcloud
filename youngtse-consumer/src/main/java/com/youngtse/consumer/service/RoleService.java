package com.youngtse.consumer.service;

import com.youngtse.common.domain.request.role.RoleAddRequest;
import com.youngtse.common.domain.request.role.RolePageRequest;
import com.youngtse.common.domain.request.role.RoleUpdateRequest;
import com.youngtse.common.domain.response.RoleResponse;
import com.youngtse.common.domain.result.Page;

/**
 * @author Youngtse
 * @title RoleService
 * @date 2023/6/9 09:50
 */
public interface RoleService {
    void addSystemRole(RoleAddRequest roleAddRequest);

    void modifyRoleByRoleId(RoleUpdateRequest roleUpdateRequest);

    void deleteRoleByRoleId(Long id);

    Page<RoleResponse> queryList(RolePageRequest rolePageRequest);
}
