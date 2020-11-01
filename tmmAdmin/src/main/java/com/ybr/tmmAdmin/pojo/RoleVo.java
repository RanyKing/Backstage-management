package com.ybr.tmmAdmin.pojo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoleVo {
    private Integer role_id;
    private String role_name;
    private Integer yrole_id; //代表当前角色已经拥有的角色id
    private Integer[] roleids;
    private List<PermissionVo> permissionVoList =new ArrayList<>();

    public List<PermissionVo> getPermissionVoList() {
        return permissionVoList;
    }

    public void setPermissionVoList(List<PermissionVo> permissionVoList) {
        this.permissionVoList = permissionVoList;
    }

    public Integer[] getRoleids() {
        return roleids;
    }

    public void setRoleids(Integer[] roleids) {
        this.roleids = roleids;
    }


    public Integer getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public Integer getYrole_id() {
        return yrole_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setYrole_id(Integer yrole_id) {
        this.yrole_id = yrole_id;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", yrole_id=" + yrole_id +
                ", roleids=" + Arrays.toString(roleids) +
                ", permissionVoList=" + permissionVoList +
                '}';
    }

}

