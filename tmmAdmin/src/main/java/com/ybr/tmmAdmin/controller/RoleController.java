package com.ybr.tmmAdmin.controller;

import com.ybr.tmmAdmin.Service.RoleService;
import com.ybr.tmmAdmin.pojo.PermissionVo;
import com.ybr.tmmAdmin.pojo.Role;
import com.ybr.tmmAdmin.pojo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Permission;
import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService rs;

    //获取角色列表
    @RequestMapping("/admin")
    public String getRoleList(Model model){
        List<Role> roleList = rs.getRoleList();
        model.addAttribute("roleList",roleList);
        return null;
    }

    //修改角色
    @RequestMapping("/update")
    public String getRoleById(Integer id,Model model){
        //根据当前的角色id获取角色信息
        List<RoleVo> roleVoList = rs.getRoleById(id);
        model.addAttribute("role_id",roleVoList.get(0).getRole_id());
        model.addAttribute("role_name",roleVoList.get(0).getRole_name());
        model.addAttribute("roleVoList",roleVoList.get(0).getPermissionVoList());
        System.out.println(roleVoList.get(0).getPermissionVoList());
        return "role/update";
    }

    //执行修改角色操作
    @RequestMapping("/alter")
    public String alter(PermissionVo permissionVo){
        System.out.println(permissionVo);
        //往中间表中插入关联的数据信息
        rs.update(permissionVo);
        rs.insertRolePermission(permissionVo.getRole_id(),permissionVo.getPermissionIds());
        return "redirect:/role/admin";
    }

    //添加角色
    @RequestMapping("/add")
    public String add(Model model){
        //查询出所有操作
        List<Permission> permissionList=rs.getPermissionList();
        model.addAttribute("permissionList",permissionList);
        return "role/add";
    }

    //确认添加角色操作
    @RequestMapping("/save")
    public String addRole(PermissionVo permissionVo){
        rs.addRole(permissionVo);
        return "redirect:/role/admin";
    }

    //删除角色操作
    @RequestMapping("/delete")
    public String deleteRole(Integer id){
        Integer role_id = id;
        //根据id删除角色信息
        rs.deleteRole(role_id);
        return "redirect:/role/admin";
    }

}
