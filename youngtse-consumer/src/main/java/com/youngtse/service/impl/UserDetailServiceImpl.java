package com.youngtse.service.impl;

import com.youngtse.domain.entity.UserAccount;
import com.youngtse.domain.model.UserDetail;
import com.youngtse.enums.AuthResultEnum;
import com.youngtse.exception.BusinessException;
import com.youngtse.mapper.master.UserAccountMasterMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Title: UserDetailServiceImpl
 * @Date 2023/5/24 0:05
 * @Author Youngtse
 * @Description: TODO
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserAccountMasterMapper userAccountMasterMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountMasterMapper.getUserAccountByUserName(username);

        // TODO: 2023/5/24 查询对应的权限信息

        return new UserDetail(userAccount);
    }


}
