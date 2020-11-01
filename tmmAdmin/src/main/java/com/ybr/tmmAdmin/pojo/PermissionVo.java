package com.ybr.tmmAdmin.pojo;


import java.util.Arrays;

public class PermissionVo {
    private Integer role_id;
    private String role_name;
    private Integer permission_id;
    private Integer pid;
    private String permission_name;
    private Integer[] permissionIds;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer[] getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Integer[] permissionIds) {
        this.permissionIds = permissionIds;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public Integer getPermission_id() {
        return permission_id;
    }

    public Integer getPid() {
        return pid;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    @Override
    public String toString() {
        return "PermissionVo{" +
                "role_id=" + role_id +
                ", role_name=" + role_name +
                ", permission_id=" + permission_id +
                ", pid=" + pid +
                ", permission_name='" + permission_name + '\'' +
                ", permissionIds=" + Arrays.toString(permissionIds) +
                '}';
    }
}
