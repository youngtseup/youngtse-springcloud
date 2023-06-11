package com.youngtse.common.mapper;

import com.youngtse.common.domain.entity.RoleMenuMapping;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuMappingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleMenuMapping row);

    int insertSelective(RoleMenuMapping row);

    RoleMenuMapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenuMapping row);

    int updateByPrimaryKey(RoleMenuMapping row);
}