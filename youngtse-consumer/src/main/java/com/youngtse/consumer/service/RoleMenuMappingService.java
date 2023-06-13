package com.youngtse.consumer.service;

import com.youngtse.common.domain.request.menu.mapping.RoleMenuMappingRequest;
import com.youngtse.common.domain.response.RoleMenuMappingResponse;

/**
 * @author Youngtse
 * @title RoleMenuMappingService
 * @date 2023/6/13 11:06
 */
public interface RoleMenuMappingService {

    void updateRoleMenuMapping(RoleMenuMappingRequest roleMenuMappingRequest);

    void deleteRoleMenuMapping(Long roleId);

    RoleMenuMappingResponse queryRoleMenuMapping(Long roleId);
}
