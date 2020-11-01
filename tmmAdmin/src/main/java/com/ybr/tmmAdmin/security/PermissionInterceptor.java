package com.ybr.tmmAdmin.security;

import com.ybr.tmmAdmin.dao.RoleDao;
import com.ybr.tmmAdmin.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * 授权 当前访问的路径，有哪些角色
 * 如果访问的路径，没有查询到角色
 * 给一个默认角色
 */

@Component
public class PermissionInterceptor implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleDao rd;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        //当前访问这个项目的url
       String requestUrl = ((FilterInvocation)o).getRequestUrl();
       //根据这个url去查询有哪些角色
        // 调用 数据访问层 根据 当前请求的URL 查询 有该权限的 角色列表
        List<Role> roleList = rd.getRoleListByOperateUrl( requestUrl );

        // 判断 有权限的角色列表 是否为空
        if( ! roleList.isEmpty() && roleList.size() > 0 ) {
            // 定义 String类型的数组 存放 授权列表
            String[] grantArray = new String[roleList.size()];
            System.out.println("********** 开始授权 **********");
            // 循环 拥有当前URL访问权限的每一个角色
            for (int i = 0; i <= roleList.size() - 1; i++) {
                // 将 当前循环到的角色的角色名称 存放 授权名称数组中
                grantArray[i] = roleList.get(i).getRole_name();
                System.out.println("** 授权角色："+roleList.get(i).getRole_name());
            }
            System.out.println("********** 授权完毕 **********");
            // 生成授权列表 返回
            return SecurityConfig.createList(grantArray);
        }else{
            // 避免返回null（任何角色都能访问）
            return SecurityConfig.createList("ROLE_LOGIN");
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return  FilterInvocation.class.isAssignableFrom(aClass);
    }
}
