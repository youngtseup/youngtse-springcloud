package com.youngtse.consumer.service;

import com.youngtse.common.domain.entity.SystemUser;
import com.youngtse.common.domain.request.SystemUserRequest;
import com.youngtse.common.domain.response.SystemUserResponse;
import com.youngtse.common.domain.result.Page;

import java.util.List;

/**
 * @author Youngtse
 * @title SystemUserService
 * @date 2023/6/8 17:21
 * @description TODO
 */
public interface SystemUserService {
    Page<SystemUserResponse> querySystemUser(SystemUserRequest systemUserRequest);
}
