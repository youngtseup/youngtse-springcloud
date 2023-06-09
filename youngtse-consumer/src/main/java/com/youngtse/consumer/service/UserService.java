package com.youngtse.consumer.service;

import com.youngtse.common.domain.request.user.UserPageRequest;
import com.youngtse.common.domain.response.SystemUserResponse;
import com.youngtse.common.domain.result.Page;

/**
 * @author Youngtse
 * @title SystemUserService
 * @date 2023/6/8 17:21
 */
public interface UserService {
    Page<SystemUserResponse> querySystemUser(UserPageRequest userPageRequest);
}
