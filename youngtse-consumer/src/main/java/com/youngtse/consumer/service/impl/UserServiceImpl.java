package com.youngtse.consumer.service.impl;

import com.youngtse.common.domain.request.user.UserPageRequest;
import com.youngtse.common.domain.response.SystemUserResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.mapper.SystemUserMapper;
import com.youngtse.consumer.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Youngtse
 * @title SystemUserServiceImpl
 * @date 2023/6/8 17:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SystemUserMapper systemUserMapper;

    @Override
    public Page<SystemUserResponse> querySystemUser(UserPageRequest userPageRequest) {
        Page<SystemUserResponse> page = new Page<>();
        page.setList(systemUserMapper.queryListByPageRequest(userPageRequest));
        page.setCount(systemUserMapper.queryCountByPageRequest(userPageRequest));
        return page;
    }
}
