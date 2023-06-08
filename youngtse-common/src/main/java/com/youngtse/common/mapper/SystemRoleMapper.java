package com.youngtse.common.mapper;

import com.youngtse.common.domain.entity.SystemRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemRole row);

    int insertSelective(SystemRole row);

    SystemRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemRole row);

    int updateByPrimaryKey(SystemRole row);
}