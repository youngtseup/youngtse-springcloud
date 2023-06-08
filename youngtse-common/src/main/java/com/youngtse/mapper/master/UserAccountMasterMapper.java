package com.youngtse.mapper.master;

import com.youngtse.domain.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: UserAccountMasterMapper
 * @Date 2023/5/13 2:04
 * @Author Youngtse
 * @Description: TODO
 */
@Mapper
public interface UserAccountMasterMapper {

    UserAccount getUserAccountById(@Param("id") Long id);

    UserAccount getUserAccountByUuid(@Param("uuid") String uuid);

    UserAccount getUserAccountByUserName(@Param("userName") String userName);

    void insertUserAccount(UserAccount userAccount);

    void updateUserAccount(UserAccount userAccount);

    void deleteUserAccountById(@Param("id") Long id);

}
