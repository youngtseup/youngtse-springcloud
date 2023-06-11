package com.youngtse.consumer.service.impl;

import com.youngtse.common.domain.entity.SystemUser;
import com.youngtse.common.domain.request.user.UserAddRequest;
import com.youngtse.common.domain.request.user.UserUpdateRequest;
import com.youngtse.common.domain.request.user.UserPageRequest;
import com.youngtse.common.domain.response.UserResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.enums.BaseResultEnum;
import com.youngtse.common.exception.BusinessException;
import com.youngtse.common.mapper.SystemUserMapper;
import com.youngtse.common.util.RsaUtil;
import com.youngtse.consumer.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Youngtse
 * @title SystemUserServiceImpl
 * @date 2023/6/8 17:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SystemUserMapper systemUserMapper;

    @Value("#${customize.privateKey}")
    private String privateKey;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<UserResponse> querySystemUser(UserPageRequest userPageRequest) {
        Page<UserResponse> page = new Page<>();
        page.setList(systemUserMapper.queryListByPageRequest(userPageRequest));
        page.setCount(systemUserMapper.queryCountByPageRequest(userPageRequest));
        return page;
    }

    @Override
    public void addSystemUser(UserAddRequest userAddRequest) {
        String decryptPwd = userAddRequest.getPassword();
        String encryptPwd = null;
        try {
            encryptPwd = RsaUtil.decrypt(privateKey, decryptPwd);
        } catch (Exception e) {
            throw new BusinessException(BaseResultEnum.DECRYPT_ERROR);
        }
        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(userAddRequest, systemUser);
        systemUser.setPassword(passwordEncoder.encode(encryptPwd));
        systemUser.setCreateTime(new Date());
        systemUser.setModifyTime(new Date());
        systemUserMapper.insert(systemUser);
    }

    @Override
    public void deleteUserByUserId(Long userId) {
        int row = systemUserMapper.deleteByPrimaryKey(userId);
        if (row < 1) {
            throw new BusinessException(BaseResultEnum.RECODE_NOT_EXIST);
        }
    }

    @Override
    public void modifyUserByUserId(UserUpdateRequest userUpdateRequest) {
        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(userUpdateRequest, systemUser);
        systemUser.setModifyTime(new Date());
        systemUserMapper.updateByPrimaryKeySelective(systemUser);
    }
}
