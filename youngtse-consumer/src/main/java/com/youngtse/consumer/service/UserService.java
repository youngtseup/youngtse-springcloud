package com.youngtse.consumer.service;

import com.youngtse.common.domain.request.user.UserAddRequest;
import com.youngtse.common.domain.request.user.UserUpdateRequest;
import com.youngtse.common.domain.request.user.UserPageRequest;
import com.youngtse.common.domain.response.UserResponse;
import com.youngtse.common.domain.result.Page;

/**
 * @author Youngtse
 * @title SystemUserService
 * @date 2023/6/8 17:21
 */
public interface UserService {
    Page<UserResponse> querySystemUser(UserPageRequest userPageRequest);

    void addSystemUser(UserAddRequest userAddRequest);

    void deleteUserByUserId(Long userId);

    void modifyUserByUserId(UserUpdateRequest userUpdateRequest);
}
