package com.ybr.tmmAdmin.controller;

import com.ybr.tmmAdmin.Service.BrandService;
import com.ybr.tmmAdmin.Service.CategoryService;
import com.ybr.tmmAdmin.pojo.Brand;
import com.ybr.tmmAdmin.pojo.Category;
import com.ybr.tmmAdmin.pojo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;


    @RequestMapping("/admin")
    public String getCateList(Model model){
        List<Category> categoryList = categoryService.getCateList();
        model.addAttribute("categoryList",categoryList);
        System.out.println(categoryList);
        return "category/admin";
    }

    //添加分类 获取品牌信息
    @RequestMapping("/add")
    public String getBrand(Model model){
        List<Brand> brandList = brandService.getBrandList();
        System.out.println(brandList);
        model.addAttribute("brandList",brandList);
        return "category/add";
    }

    //执行添加操作
    @RequestMapping("/save")
    public String insertCate(CategoryVo categoryVo){
        categoryVo.setCreatetime(new Date());
        categoryVo.setUpdatetime(new Date());
        System.out.println("品牌id为："+categoryVo.getBrand_id());
        //添加分类
        categoryService.insertCate(categoryVo);
        return "redirect:/category/admin";
    }

    //执行删除操作
    @RequestMapping("/delete")
    public String deleteCate(Integer id){
        categoryService.deleteCateById(id);
        return "redirect:/category/admin";
    }

    //修改
    @RequestMapping("/update")
    public String updateById(Integer id,Model model){
        Category category = categoryService.getCateById(id);
        model.addAttribute("category",category);
        return "category/update";
    }

    //执行修改操作
    @RequestMapping("/alter")
    public String updateCate(Category category){
        System.out.println(category);
        categoryService.updateCate(category);
        return "redirect:/category/admin";
    }

}
