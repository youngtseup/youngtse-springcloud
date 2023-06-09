package com.youngtse.consumer.service.impl;

import com.youngtse.common.domain.entity.SystemRole;
import com.youngtse.common.domain.request.role.AddRoleRequest;
import com.youngtse.common.domain.request.role.QueryRoleRequest;
import com.youngtse.common.domain.request.role.UpdateRoleRequest;
import com.youngtse.common.domain.response.SystemRoleResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.enums.BaseResultEnum;
import com.youngtse.common.exception.BusinessException;
import com.youngtse.common.mapper.SystemRoleMapper;
import com.youngtse.consumer.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Youngtse
 * @title RoleServiceImpl
 * @date 2023/6/9 09:55
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private SystemRoleMapper systemRoleMapper;

    @Override
    public void addSystemRole(AddRoleRequest addRoleRequest) {
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(addRoleRequest, systemRole);
        systemRole.setCreateTime(new Date());
        systemRole.setModifyTime(new Date());
        systemRoleMapper.insert(systemRole);
    }

    @Override
    public void modifyRoleByRoleId(UpdateRoleRequest updateRoleRequest) {
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(updateRoleRequest, systemRole);
        systemRole.setModifyTime(new Date());
        systemRoleMapper.updateByPrimaryKeySelective(systemRole);
    }

    @Override
    public void deleteRoleByRoleId(Integer id) {
        // TODO: 2023/6/9 校验该角色没有关联用户和菜单才能删除
        int row = systemRoleMapper.deleteByPrimaryKey(id);
        if (row < 1) {
            throw new BusinessException(BaseResultEnum.RECODE_NOT_EXIST);
        }
    }

    @Override
    public Page<SystemRoleResponse> queryList(QueryRoleRequest queryRoleRequest) {
        Page<SystemRoleResponse> page = new Page<>();
        List<SystemRoleResponse> list = systemRoleMapper.queryListByRoleRequest(queryRoleRequest);
        int count = systemRoleMapper.queryCountByRoleRequest(queryRoleRequest);
        page.setList(list);
        page.setCount(count);
        return page;
    }
}
