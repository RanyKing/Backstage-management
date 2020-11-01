package com.ybr.tmmAdmin.dao;

import com.ybr.tmmAdmin.pojo.PermissionVo;
import com.ybr.tmmAdmin.pojo.Role;
import com.ybr.tmmAdmin.pojo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.security.Permission;
import java.util.List;

public interface RoleDao {
    /**
     * 根据员工编号查询该员工的角色列表
     * @param admin_id 要查询角色列表的员工的员工编号
     * @return 该员工的角色列表
     * */
    List<Role> getRoleListByAdminId(@Param("admin_id") Integer admin_id );


    /**
     * 根据操作请求的URL获取有该URL访问权限的角色列表
     * @param operate_url 操作请求的URL
     * @return 有该URL访问权限的角色列表
     * */
    List<Role> getRoleListByOperateUrl( @Param("operate_url") String operate_url );

    /**
     * 获取整个角色列表
     * @return
     */
    List<Role> getRoleList();

    /**
     * 根据当前的用户id查询角色信息
     * @param id 当前的用户id
     * @return
     */
    List<RoleVo> getRoleListById(@Param("admin_id") Integer id);

    /**
     * 往权限表中插入用户id和角色id
     * @param admin_id 用户id
     * @param roleids 角色id
     */
    void insertAdminRole(@Param("admin_id") Integer admin_id, @Param("roleids") Integer[] roleids);


    /**
     * 根据角色id获取角色列表
     * @param id 角色id
     * @return
     */
    List<PermissionVo> getpermissionById(@Param("role_id") Integer id);

    /**
     * 根据角色id查询出角色信息
     * @param id 角色id
     * @return
     */
    List<RoleVo> getRoleById(@Param("role_id") Integer id);

    /**
     * 根据角色id和授权id往数据库的role_permission表中插入数据信息
     * @param role_id 角色id
     * @param permissionIds 授权的id数组
     */
    void insertRolePermission(@Param("role_id") Integer role_id, @Param("permissionIds") Integer[] permissionIds);

    /**
     * 根据角色id先删除关联数据
     * @param role_id 角色id
     */
    void deleteRolePermission(@Param("role_id") Integer role_id);

    /**
     * 查询permission的操作列表
     * @return
     */
    List<Permission> getPermissionList();

    /**
     * 往数据库中添加角色
     * @param permissionVo
     */
    void addRole(PermissionVo permissionVo);

    /**
     * 往role_permission中间边插入关联
     * @param role_id
     * @param permissionIds
     */
    void addRolePermission(@Param("role_id") Integer role_id, @Param("permissionIds") Integer[] permissionIds);

    /**
     * 根据角色id删除角色
     * @param role_id
     */
    void deleteRole(@Param("role_id") Integer role_id);

    /**
     * 更改角色信息
     * @param permissionVo
     */
    void update(PermissionVo permissionVo);
}
