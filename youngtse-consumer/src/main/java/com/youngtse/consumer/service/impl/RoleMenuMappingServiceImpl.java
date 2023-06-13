package com.youngtse.consumer.service.impl;
import com.google.common.collect.Lists;

import com.youngtse.common.domain.dto.RoleMenuMappingDTO;
import com.youngtse.common.domain.entity.SystemRole;
import com.youngtse.common.domain.request.menu.mapping.RoleMenuMappingRequest;
import com.youngtse.common.domain.response.RoleMenuMappingResponse;
import com.youngtse.common.enums.BaseResultEnum;
import com.youngtse.common.exception.BusinessException;
import com.youngtse.common.mapper.RoleMenuMappingMapper;
import com.youngtse.common.mapper.SystemRoleMapper;
import com.youngtse.consumer.service.RoleMenuMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author Youngtse
 * @title RoleMenuMappingServiceImpl
 * @date 2023/6/13 11:07
 */
@Service
public class RoleMenuMappingServiceImpl implements RoleMenuMappingService {

    @Resource
    private RoleMenuMappingMapper roleMenuMappingMapper;

    @Resource
    private SystemRoleMapper systemRoleMapper;

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public void updateRoleMenuMapping(RoleMenuMappingRequest roleMenuMappingRequest) {
        Long roleId = roleMenuMappingRequest.getRoleId();
        SystemRole systemRole = systemRoleMapper.selectByPrimaryKey(roleId);
        if (Objects.isNull(systemRole)) {
            throw new BusinessException(BaseResultEnum.ROLE_NOT_EXIST);
        }
        // TODO: 2023/6/13 校验roleMenuMappingRequest.menuIdList保证菜单表中全部能够查询到
        roleMenuMappingMapper.deleteByRoleId(roleId);
        roleMenuMappingMapper.insertBatch(roleMenuMappingRequest);
    }

    @Override
    public void deleteRoleMenuMapping(Long roleId) {
        int row = roleMenuMappingMapper.deleteByRoleId(roleId);
        if (row < 1) {
            throw new BusinessException(BaseResultEnum.RECODE_NOT_EXIST);
        }
    }

    @Override
    public RoleMenuMappingResponse queryRoleMenuMapping(Long roleId) {
        SystemRole systemRole = systemRoleMapper.selectByPrimaryKey(roleId);
        if (Objects.isNull(systemRole)) {
            throw new BusinessException(BaseResultEnum.ROLE_NOT_EXIST);
        }
        List<RoleMenuMappingDTO> list = roleMenuMappingMapper.queryByRoleId(roleId);
        RoleMenuMappingResponse roleMenuMappingResponse = new RoleMenuMappingResponse();
        roleMenuMappingResponse.setRoleId(systemRole.getId());
        roleMenuMappingResponse.setRoleName(systemRole.getRoleName());
        roleMenuMappingResponse.setMenuList(list);
        return roleMenuMappingResponse;
    }
}
