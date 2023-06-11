package com.youngtse.consumer.service;

import com.youngtse.common.domain.request.menu.MenuAddRequest;
import com.youngtse.common.domain.request.menu.MenuPageRequest;
import com.youngtse.common.domain.request.menu.MenuUpdateRequest;
import com.youngtse.common.domain.response.MenuResponse;
import com.youngtse.common.domain.result.Page;

/**
 * @Title: MenuService
 * @Date 2023/6/11 15:06
 * @Author Youngtse
 */
public interface MenuService {
    void addMenu(MenuAddRequest menuAddRequest);

    void deleteMenu(Long menuId);

    void modifyMenu(MenuUpdateRequest menuUpdateRequest);

    Page<MenuResponse> queryMenu(MenuPageRequest menuPageRequest);
}
