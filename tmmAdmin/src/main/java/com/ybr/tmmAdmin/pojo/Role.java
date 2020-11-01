package com.ybr.tmmAdmin.pojo;

import org.springframework.security.core.GrantedAuthority;


/**
 * 要授权的用的哪个实体类
 */
public class Role implements GrantedAuthority {
    private Integer role_id;
    private String role_name;

    //获取授权的角色
    @Override
    public String getAuthority() {
        return this.getRole_name();
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }
}
