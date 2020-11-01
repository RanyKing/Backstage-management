package com.ybr.tmmAdmin.Service.Impl;

import com.ybr.tmmAdmin.Service.AdminService;
import com.ybr.tmmAdmin.dao.AdminDao;
import com.ybr.tmmAdmin.dao.RoleDao;
import com.ybr.tmmAdmin.pojo.Admin;
import com.ybr.tmmAdmin.pojo.AdminVo;
import com.ybr.tmmAdmin.pojo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao ad;

    @Autowired
    private RoleDao rd;

    @Override
    public List<Admin> getAdminList(String admin_name,String admin_nickname) {
        return ad.getAdminList(admin_name,admin_nickname);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return ad.getAdminByName(username);
    }

    @Override
    public void addAdmin(AdminVo adminVo) {
        //插入用户
        ad.addAdmin(adminVo);
        //判断当前添加的用户是否有权限
        if(null!=adminVo.getAdmin_pass()){
            ad.addAdminRole(adminVo.getAdmin_id(),adminVo.getRoleids());
        }

    }

    @Override
    public void deleteAdmin(Integer id) {
        ad.deleteAdmin(id);
    }

    @Override
    public AdminVo getAdminById(Integer id) {
        AdminVo adminVo = ad.getAdminById(id);
        List<RoleVo> roleVoList=rd.getRoleListById(id);
        adminVo.setRoleVoList(roleVoList);
        return adminVo;
    }

    @Override
    public void updateAdmin(AdminVo adminVo) {
        //修改数据库中用户名和昵称，和角色id
        ad.updateAdmin(adminVo);
        //删除角色信息
        System.out.println(adminVo.getAdmin_id());
        for (Integer a:adminVo.getRoleids()
             ) {
            System.out.println(a);
        }
        ad.deleteAdminRole(adminVo.getAdmin_id());
        //重新插入员工的角色信息
        rd.insertAdminRole(adminVo.getAdmin_id(),adminVo.getRoleids());
    }


}
