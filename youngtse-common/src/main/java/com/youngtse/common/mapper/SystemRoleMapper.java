package com.youngtse.common.mapper;

import com.youngtse.common.domain.entity.SystemRole;
import com.youngtse.common.domain.request.role.QueryRoleRequest;
import com.youngtse.common.domain.response.SystemRoleResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemRole row);

    int insertSelective(SystemRole row);

    SystemRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemRole row);

    int updateByPrimaryKey(SystemRole row);

    List<SystemRoleResponse> queryListByRoleRequest(QueryRoleRequest queryRoleRequest);

    int queryCountByRoleRequest(QueryRoleRequest queryRoleRequest);
}