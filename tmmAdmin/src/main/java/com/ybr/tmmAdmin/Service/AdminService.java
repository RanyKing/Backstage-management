package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.pojo.Admin;
import com.ybr.tmmAdmin.pojo.AdminVo;

import java.util.List;


public interface AdminService {

    /**
     * 根据输入的信息进行获取用户列表
     * @param admin_name 用户名
     * @param admin_nickname 用户昵称
     * @return
     */
     List<Admin> getAdminList(String admin_name,String admin_nickname);

    /**
     * 根据登录的用户名来查询用户信息
     * @param username 当前登录的用户名
     * @return
     */
    Admin getAdminByUsername(String username);

    /**
     * 往数据库中添加一个新用户
     * @param adminVo 提交的用户实体
     */
    void addAdmin(AdminVo adminVo);

    /**
     * 根据选择的admin_id来删除用户
     * @param id admin_id
     */
    void deleteAdmin(Integer id);

    /**
     * 根据id查询出当前的用户的信息
     * @param id 用户的id
     * @return
     */
    AdminVo getAdminById(Integer id);

    /**
     * 修改当前员工的信息
     * @param adminVo
     */
    void updateAdmin(AdminVo adminVo);
}
