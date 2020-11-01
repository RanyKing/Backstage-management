package com.ybr.tmmAdmin.dao;

import com.ybr.tmmAdmin.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    /**
     * 根据当前的用户名的id来查找此用户权限下的菜单
     * @param admin_id 当前登录的用户名
     * @return
     */
    List<Menu> getMenulist(@Param("admin_id") Integer admin_id);
}
