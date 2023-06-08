package com.youngtse.mapper.master;

import com.youngtse.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title: RoleMasterMapper
 * @Date 2023/5/18 23:06
 * @Author Youngtse
 * @Description: TODO
 */
@Mapper
public interface RoleMasterMapper {

    int insertRole(Role role);

    int updateRole(Role role);

    int deleteRoleById(Long id);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

}
