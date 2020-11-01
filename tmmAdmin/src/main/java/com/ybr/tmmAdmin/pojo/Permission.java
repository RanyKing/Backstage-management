package com.ybr.tmmAdmin.pojo;

public class Permission {
    private Integer permission_id;
    private String permission_name;
    private Integer pid;

    public Integer getPermission_id() {
        return permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission_id=" + permission_id +
                ", permission_name='" + permission_name + '\'' +
                ", pid=" + pid +
                '}';
    }
}
