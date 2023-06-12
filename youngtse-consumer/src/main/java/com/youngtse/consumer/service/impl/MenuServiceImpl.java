package com.youngtse.consumer.service.impl;

import com.youngtse.common.domain.entity.SystemMenu;
import com.youngtse.common.domain.request.menu.MenuAddRequest;
import com.youngtse.common.domain.request.menu.MenuPageRequest;
import com.youngtse.common.domain.request.menu.MenuUpdateRequest;
import com.youngtse.common.domain.response.MenuResponse;
import com.youngtse.common.domain.result.Page;
import com.youngtse.common.enums.BaseResultEnum;
import com.youngtse.common.exception.BusinessException;
import com.youngtse.common.mapper.SystemMenuMapper;
import com.youngtse.consumer.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Title: MenuServiceImpl
 * @Date 2023/6/11 15:58
 * @Author Youngtse
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private SystemMenuMapper systemMenuMapper;

    @Override
    public void addMenu(MenuAddRequest menuAddRequest) {
        SystemMenu systemMenu = new SystemMenu();
        BeanUtils.copyProperties(menuAddRequest, systemMenu);
        systemMenu.setCreateTime(new Date());
        systemMenu.setModifyTime(new Date());
        systemMenuMapper.insert(systemMenu);
    }

    @Override
    public void deleteMenu(Long menuId) {
        MenuPageRequest menuPageRequest = new MenuPageRequest();
        menuPageRequest.setPid(menuId);
        int count = systemMenuMapper.queryCountByMenuRequest(menuPageRequest);
        if (count > 0) {
            throw new BusinessException(BaseResultEnum.MENU_PID_EXIST);
        }
        int row = systemMenuMapper.deleteByPrimaryKey(menuId);
        if (row < 1) {
            throw new BusinessException(BaseResultEnum.RECODE_NOT_EXIST);
        }
    }

    @Override
    public void modifyMenu(MenuUpdateRequest menuUpdateRequest) {
        SystemMenu systemMenu = new SystemMenu();
        BeanUtils.copyProperties(menuUpdateRequest, systemMenu);
        systemMenu.setModifyTime(new Date());
        systemMenuMapper.updateByPrimaryKeySelective(systemMenu);
    }

    @Override
    public Page<MenuResponse> queryMenu(MenuPageRequest menuPageRequest) {
        Page<MenuResponse> page = new Page<>();
        List<MenuResponse> list = systemMenuMapper.queryListByMenuRequest(menuPageRequest);
        int count = systemMenuMapper.queryCountByMenuRequest(menuPageRequest);
        page.setList(list);
        page.setCount(count);
        return page;
    }
}
