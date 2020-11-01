package com.ybr.tmmAdmin.Service.Impl;

import com.ybr.tmmAdmin.Service.RoleService;
import com.ybr.tmmAdmin.dao.RoleDao;
import com.ybr.tmmAdmin.pojo.PermissionVo;
import com.ybr.tmmAdmin.pojo.Role;
import com.ybr.tmmAdmin.pojo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao rd;

    @Override
    public List<Role> getRoleList() {
        return rd.getRoleList();
    }

    @Override
    public List<RoleVo> getRoleById(Integer id) {
        return rd.getRoleById(id);
    }

    @Override
    public void insertRolePermission(Integer role_id, Integer[] permissionIds) {
        //先删除当前角色id下授权的数据
        rd.deleteRolePermission(role_id);
        rd.insertRolePermission(role_id,permissionIds);
    }

    @Override
    public List<Permission> getPermissionList() {
        return rd.getPermissionList();
    }

    @Override
    public void addRole(PermissionVo permissionVo) {
        rd.addRole(permissionVo);
        rd.addRolePermission(permissionVo.getRole_id(),permissionVo.getPermissionIds());
    }

    @Override
    public void deleteRole(Integer role_id) {
        //首先根据id先删除关联表的信息
        rd.deleteRolePermission(role_id);
        //在根据角色id删除角色
        rd.deleteRole(role_id);
    }

    @Override
    public void update(PermissionVo permissionVo) {
        rd.update(permissionVo);
    }


}
