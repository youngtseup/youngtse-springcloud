package com.youngtse.consumer.service.impl;

import com.youngtse.common.domain.entity.SystemUser;
import com.youngtse.common.mapper.SystemUserMapper;
import com.youngtse.consumer.domain.model.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Title: UserDetailServiceImpl
 * @Date 2023/5/24 0:05
 * @Author Youngtse
 * @Description: TODO
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private SystemUserMapper systemUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = systemUserMapper.getSystemUserByUsername(username);

        // TODO: 2023/5/24 查询对应的权限信息

        return new UserDetail(systemUser);
    }


}
