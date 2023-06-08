package com.youngtse.consumer.service.impl;

import com.youngtse.common.domain.entity.SystemUser;
import com.youngtse.common.domain.request.SystemUserRequest;
import com.youngtse.common.domain.response.SystemUserResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.mapper.SystemUserMapper;
import com.youngtse.consumer.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Youngtse
 * @title SystemUserServiceImpl
 * @date 2023/6/8 17:48
 * @description TODO
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    private SystemUserMapper systemUserMapper;

    @Override
    public Page<SystemUserResponse> querySystemUser(SystemUserRequest systemUserRequest) {
        Page<SystemUserResponse> page = new Page<>();
        page.setList(systemUserMapper.queryListByPageRequest(systemUserRequest));
        page.setCount(systemUserMapper.queryCountByPageRequest(systemUserRequest));
        return page;
    }
}
