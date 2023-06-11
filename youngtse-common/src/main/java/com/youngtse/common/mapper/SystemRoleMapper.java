package com.youngtse.common.mapper;

import com.youngtse.common.domain.entity.SystemRole;
import com.youngtse.common.domain.request.role.RolePageRequest;
import com.youngtse.common.domain.response.RoleResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemRole row);

    int insertSelective(SystemRole row);

    SystemRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemRole row);

    int updateByPrimaryKey(SystemRole row);

    List<RoleResponse> queryListByRoleRequest(RolePageRequest rolePageRequest);

    int queryCountByRoleRequest(RolePageRequest rolePageRequest);
}