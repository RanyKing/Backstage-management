package com.ybr.tmmAdmin.controller;

import com.ybr.tmmAdmin.Service.AdminService;
import com.ybr.tmmAdmin.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/","/index"})
public class IndexController {

    @Autowired
    private AdminService as;

    @RequestMapping(value = {"/","/index"})
    public String index(Authentication auth, HttpSession session){
        //获取当前登录的用户名
        String username = auth.getName();
        Admin admin = as.getAdminByUsername(username);
        session.setAttribute("fmlist",admin.getFmenuList());
        session.setAttribute("uname",admin.getAdmin_nickname());
        session.setAttribute("roleList",admin.getRoleList());
        return "index/tmmadminindex.html";
    }
}
