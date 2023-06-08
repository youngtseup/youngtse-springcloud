package com.youngtse.common.mapper;

import com.youngtse.common.domain.entity.SystemUser;
import com.youngtse.common.domain.request.SystemUserRequest;
import com.youngtse.common.domain.response.SystemUserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemUser row);

    int insertSelective(SystemUser row);

    SystemUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemUser row);

    int updateByPrimaryKey(SystemUser row);

    SystemUser getSystemUserByUsername(@Param("username") String username);

    List<SystemUserResponse> queryListByPageRequest(SystemUserRequest systemUserRequest);

    int queryCountByPageRequest(SystemUserRequest systemUserRequest);
}