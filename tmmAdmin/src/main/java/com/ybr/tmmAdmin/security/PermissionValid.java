package com.ybr.tmmAdmin.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 认证，当前用户有没有权限访问
 */

@Component
public class PermissionValid implements AccessDecisionManager {
    /**
     *
     * @param authentication authentication当前登录的用户
     * @param o 可以理解就是request
     * @param collection 代表的就是当前这个url对应的角色列表
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println( "********** 开始权限认证 **********" );
        // 迭代遍历 当前请求的URL授权的所有角色
        for( ConfigAttribute attr : collection ){
            // 判断 当前登录的用户对象 是否是 空
            if( authentication == null ){
                System.out.println("********** 权限认证失败！");
                throw new AccessDeniedException("权限认证失败！");
            }
            // 获取 当前迭代到的 授权的角色的角色名称
            String grantName = attr.getAttribute();
            // 判断 是否有默认授权 （公共资源，只需要判断用户是否已经登录）
            if( "ROLE_LOGIN".equals(grantName) ){
                // 判断 当前用户是否已经登录
                if( authentication instanceof AnonymousAuthenticationToken){
                    System.out.println("********** 用户还未登录！");
                    throw new BadCredentialsException("请先登录");
                }else{
                    // 当前用户已经登录 可以访问 公共资源
                    System.out.println("********** 公共资源！已登录的用户认证通过！");
                    return;
                }
            }
            // 获取 当前用户的角色列表
            Collection<? extends GrantedAuthority> roleList = authentication.getAuthorities();

            // 迭代遍历 当前用户的角色列表
            for( GrantedAuthority role : roleList ){
                System.out.println( "** 授权角色 : " + grantName + " => 用户角色 : " + role.getAuthority() );
                // 判断 当前迭代到的用户角色 是否就是 当前外循环迭代到的 授权角色
                if( grantName.equals( role.getAuthority() ) ){
                    System.out.println( "**  权限认证成功！" );
                    return;
                }
            }
        }
        System.out.println( "********** 权限认证结束 **********" );
        // 当前用户没有 该 URL的访问权限
        System.out.println("********** 权限认证失败！");
        throw new AccessDeniedException("权限认证失败！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
