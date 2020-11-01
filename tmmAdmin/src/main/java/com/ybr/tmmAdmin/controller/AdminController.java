package com.ybr.tmmAdmin.controller;

import com.ybr.tmmAdmin.Service.AdminService;
import com.ybr.tmmAdmin.Service.RoleService;
import com.ybr.tmmAdmin.pojo.Admin;
import com.ybr.tmmAdmin.pojo.AdminVo;
import com.ybr.tmmAdmin.pojo.Role;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService as;

    @Autowired
    private RoleService rs;

    @RequestMapping("/login")
    public String login(){
       return "admin/login";
    }

    @RequestMapping("/dologin")
    public String dologin(String username,String password){
        return null;
    }

    @RequestMapping("/admin")
    public String getAdminList(Model model, String admin_name, String admin_nickname, HttpSession session){
        List<Admin> list = as.getAdminList(admin_name,admin_nickname);
        //存放在session中便于下载
        session.setAttribute("adminList",list);
        //用于刷新后显示在输入框中
        model.addAttribute("aname",admin_name);
        model.addAttribute("anickname",admin_nickname);
        model.addAttribute("alist",list);
        return "admin/admin";
    }

    @RequestMapping("/add")
    public String getRoleList(Model model){
       List<Role> roleList = rs.getRoleList();
       model.addAttribute("roleList",roleList);
        return "admin/add";
    }

    @RequestMapping("/save")
    public String addAdmin(AdminVo adminVo){
        //给新用户设置初始密码admin，并且进行加密
        adminVo.setAdmin_pass(new BCryptPasswordEncoder().encode("admin"));
        as.addAdmin(adminVo);
        return "redirect:/admin/admin";
    }

    @RequestMapping("/delete")
    public String deleteAdmin(Integer id){
        as.deleteAdmin(id);
        return "redirect:/admin/admin";
    }

    //修改用户
    @RequestMapping("/update")
    public String updateAdmin(Integer id,Model model){
        //根据用户id查找当前用户的信息
        AdminVo adminVo = as.getAdminById(id);
        model.addAttribute("adminvo",adminVo);
        return "admin/update";
    }

    //执行修改操作
    @RequestMapping("/alter")
    public String saveAdmin(AdminVo adminVo){
        as.updateAdmin(adminVo);
        return "redirect:/admin/admin";
    }

    //下载用户表
    @RequestMapping("/download")
    public void download(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {

        //判断是否存在这个文件如果有则删除
        File file=new File("D:\\userTest\\admin.xls");
        if(file.exists()){
            file.delete();
        }

        //创建工作簿
        HSSFWorkbook workBook = new HSSFWorkbook();

        ////创建工作表  工作表（sheet）的名字叫hello
        HSSFSheet sheet = workBook.createSheet("admin");

        //属性行
        HSSFRow row01=sheet.createRow(0);
        HSSFCell cell0101=row01.createCell(0);
        cell0101.setCellValue("ID");
        HSSFCell cell0102=row01.createCell(1);
        cell0102.setCellValue("用户名");
        HSSFCell cell0103=row01.createCell(2);
        cell0103.setCellValue("昵称");

        int i=1;
        //获取session中的数据
        List<Admin> list= (List<Admin>) session.getAttribute("adminList");
        for (Admin admin:list
        ) {
            HSSFRow rowx=sheet.createRow(i);
            HSSFCell cell1=rowx.createCell(0);
            cell1.setCellValue(admin.getAdmin_id());
            HSSFCell cell2=rowx.createCell(1);
            cell2.setCellValue(admin.getAdmin_name());
            HSSFCell cell3=rowx.createCell(2);
            cell3.setCellValue(admin.getAdmin_nickname());
            i++;
        }

        workBook.write(new FileOutputStream(new File("D:\\userTest\\admin.xls")));
        workBook.close();

        //执行下载操作
        String fileName="admin.xls";
        //服务器加载用户要下载的文件数据。
        File downfile = new File("D:\\userTest\\",fileName);
        //通知浏览器以下载的方式请求资源
        //设置文件媒体格式
        response.setContentType(request.getServletContext().getMimeType(fileName));
        //解决文件下载的中文乱码问题
        //判断浏览器的类型
        String header = request.getHeader("User-Agent");
        if(header.contains("Firefox")){
        //判断如果是火狐浏览器，使用base64编码
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileName = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        }else{
        //谷歌浏览器及其他浏览器处理
            fileName = URLEncoder.encode(fileName,"utf-8");
        }
        //设置要被下载的文件的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //使用IO技术，将数据发送（使用response对象发送数据）
        //获取输入流，读取文件数据
        FileInputStream in = new FileInputStream(file);
        //获取输出流，写出文件数据
        ServletOutputStream out = response.getOutputStream();
        //定义一个缓冲区
        byte[] buf = new byte[1024];
        while(in.read(buf) != -1){
            out.write(buf);
        }
        in.close();

    }

}

