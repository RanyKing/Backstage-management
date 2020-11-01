package com.ybr.tmmAdmin.controller;

import com.ybr.tmmAdmin.Service.BrandService;
import com.ybr.tmmAdmin.Service.CategoryService;
import com.ybr.tmmAdmin.pojo.Brand;
import com.ybr.tmmAdmin.pojo.BrandVo;
import com.ybr.tmmAdmin.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/admin")
    public String getBrandList(Model model){
        //查询品牌列表
        List<Brand> brandList=brandService.getBrandList();
        model.addAttribute("brandList",brandList);
        return "brand/admin";
    }

    @RequestMapping("/add")
    public String add(Model model){
        //获取分类信息
        List<Category> category = categoryService.getCateList();
        model.addAttribute("category",category);
        System.out.println(category);
        return "brand/add";
    }


    //添加品牌
    @RequestMapping("/save")
    public String addBrand(BrandVo brandVo){
        brandVo.setCreatetime(new Date());
        brandVo.setUpdatetime(new Date());
        brandService.insertBrand(brandVo);
        return "redirect:/brand/admin";
    }

    @RequestMapping("/delete")
    public String deleteBrandById(Integer id){
        brandService.deleteBrandById(id);
        return "redirect:/brand/admin";
    }

    @RequestMapping("/update")
    public String searchBrandById(Integer id,Model model){
        Brand brand = brandService.searchBrandById(id);
        System.out.println(brand);
        model.addAttribute("brand",brand);
        return "brand/update";
    }

    //执行修改品牌
    @RequestMapping("/alter")
    public String updateBrandById(Brand brand){
        brand.setUpdatetime(new Date());
        brandService.updateBrand(brand);
        return "redirect:/brand/admin";
    }
}
