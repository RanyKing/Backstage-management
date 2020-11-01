package com.ybr.tmmAdmin.dao;

import com.ybr.tmmAdmin.pojo.Admin;
import com.ybr.tmmAdmin.pojo.AdminVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    /**
     * 根据用户名查询用户
     * @param s 当前登录的用户名
     * @return
     */
    Admin getAdminByName(@Param("admin_name") String s);

    /**
     * 获取一个用户的列表信息
     * @return
     */
    List<Admin> getAdminList(@Param("admin_name") String admin_name,@Param("admin_nickname") String admin_nickname);


    /**
     * 添加一个新的用户
     * @param adminVo 用户实体
     */
    void addAdmin(AdminVo adminVo);

    /**
     * 给新用户添加权限操作
     * @param admin_id 获取到的新添加用户的id
     * @param roleids 角色的id数组
     */
    void addAdminRole(@Param("admin_id") Integer admin_id, @Param("roleids") Integer[] roleids);

    /**
     * 根据传进来的admin_id删除用户和角色
     * @param id admin_id
     */
    void deleteAdmin(@Param("admin_id") Integer id);

    /**
     * 根据用户的id获取用户的信息
     * @param id 用户的id
     * @return
     */
    AdminVo getAdminById(@Param("admin_id") Integer id);

    /**
     * 更新数据库中的用户信息
     * @param adminVo
     */
    void updateAdmin(AdminVo adminVo);

    /**
     * 根据当前用户的id删除角色信息
     * @param admin_id 用户的id
     */
    void deleteAdminRole(@Param("admin_id") Integer admin_id);


}
