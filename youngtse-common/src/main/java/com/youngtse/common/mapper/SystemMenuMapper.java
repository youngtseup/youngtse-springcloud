package com.youngtse.common.mapper;

import com.youngtse.common.domain.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemMenu row);

    int insertSelective(SystemMenu row);

    SystemMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemMenu row);

    int updateByPrimaryKey(SystemMenu row);
}