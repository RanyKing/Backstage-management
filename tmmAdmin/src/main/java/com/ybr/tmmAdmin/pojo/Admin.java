package com.ybr.tmmAdmin.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Admin implements UserDetails {
    private Integer admin_id;       // 员工编号

    private String admin_name;      // 登录账户名称

    private String admin_pass;      // 登录账户密码

    private String admin_nickname;  // 员工昵称

    private Integer admin_status; //员工状态

    private List<Role> roleList = new ArrayList<>();//员工的角色列表

    private  List<Menu> fmenuList = new ArrayList<>();

    public List<Menu> getFmenuList() {
        return fmenuList;
    }

    public void setFmenuList(List<Menu> fmenuList) {
        this.fmenuList = fmenuList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_pass='" + admin_pass + '\'' +
                ", admin_nickname='" + admin_nickname + '\'' +
                ", admin_status=" + admin_status +
                ", roleList=" + roleList +
                ", fmenuList=" + fmenuList +
                '}';
    }

    public Integer getAdmin_status() {
        return admin_status;
    }

    public void setAdmin_status(Integer admin_status) {
        this.admin_status = admin_status;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public String getAdmin_nickname() {
        return admin_nickname;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public void setAdmin_nickname(String admin_nickname) {
        this.admin_nickname = admin_nickname;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    //获取当前用户对应的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoleList();
    }

    @Override
    public String getPassword() {
        return this.getAdmin_pass();
    }

    //登录的时候，获取的用户名
    @Override
    public String getUsername() {
        return this.getAdmin_name();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
