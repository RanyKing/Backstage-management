package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.dao.AdminDao;
import com.ybr.tmmAdmin.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 做用户登录
 */
@Service
public class AdminDetailService implements UserDetailsService {

    @Autowired
    private AdminDao ad;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //调用ad的方法根据用户名去查询用户
        // 调用 数据访问层 根据账户名称 查询 用户对象
        Admin admin = ad.getAdminByName( s );
        if( admin == null ){
            // 该账户名称的用户不存在 登录失败 用户填写的账户名称错误
            // 抛出 UsernameNotFoundException 异常对象
            throw new UsernameNotFoundException("账户名称填写错误！");
        }
        return admin;
    }
}
