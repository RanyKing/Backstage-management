package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.pojo.PermissionVo;
import com.ybr.tmmAdmin.pojo.Role;
import com.ybr.tmmAdmin.pojo.RoleVo;

import java.security.Permission;
import java.util.List;

public interface RoleService {

    /**
     * 获取角色列表
     * @return
     */
    List<Role> getRoleList();


    /**
     * 根据角色id获取权限信息
     * @param id 角色id
     * @return
     */
    List<RoleVo> getRoleById(Integer id);

    /**
     * 往数据库中间表插入数据
     * @param role_id 选择的角色id
     * @param permissionIds 选择的授权id
     */
    void insertRolePermission(Integer role_id, Integer[] permissionIds);

    /**
     * 获取permission列表
     * @return
     */
    List<Permission> getPermissionList();

    /**
     * 添加角色
     * @param permissionVo
     */
    void addRole(PermissionVo permissionVo);

    /**
     * 根据id删除角色
     * @param role_id
     */
    void deleteRole(Integer role_id);

    /**
     * 更改角色信息
     * @param permissionVo
     */
    void update(PermissionVo permissionVo);
}
