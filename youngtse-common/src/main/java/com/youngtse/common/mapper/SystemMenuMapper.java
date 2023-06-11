package com.youngtse.common.mapper;

import com.youngtse.common.domain.entity.SystemMenu;
import com.youngtse.common.domain.request.menu.MenuPageRequest;
import com.youngtse.common.domain.response.MenuResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemMenu row);

    int insertSelective(SystemMenu row);

    SystemMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemMenu row);

    int updateByPrimaryKey(SystemMenu row);

    List<MenuResponse> queryListByMenuRequest(MenuPageRequest menuPageRequest);

    int queryCountByMenuRequest(MenuPageRequest menuPageRequest);
}