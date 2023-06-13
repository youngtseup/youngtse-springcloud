package com.youngtse.common.mapper;

import com.youngtse.common.domain.dto.RoleMenuMappingDTO;
import com.youngtse.common.domain.entity.RoleMenuMapping;
import com.youngtse.common.domain.request.menu.mapping.RoleMenuMappingRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMenuMappingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleMenuMapping row);

    int insertSelective(RoleMenuMapping row);

    RoleMenuMapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenuMapping row);

    int updateByPrimaryKey(RoleMenuMapping row);

    int deleteByRoleId(@Param("roleId") Long roleId);

    void insertBatch(RoleMenuMappingRequest roleMenuMappingRequest);

    List<RoleMenuMappingDTO> queryByRoleId(@Param("roleId") Long roleId);
}