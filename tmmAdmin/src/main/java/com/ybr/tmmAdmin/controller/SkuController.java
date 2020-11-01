package com.ybr.tmmAdmin.controller;

import com.ybr.tmmAdmin.Service.CategoryService;
import com.ybr.tmmAdmin.Service.SkuService;
import com.ybr.tmmAdmin.pojo.Category;
import com.ybr.tmmAdmin.pojo.Sku;
import com.ybr.tmmAdmin.pojo.SkuKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @Autowired
    private CategoryService categoryService;

    //获取首页属性键列表
    @RequestMapping("/admin")
    public String getSpuList(Model model){
        List<Sku> skuList = skuService.getSkuList();
        model.addAttribute("skuList",skuList);
        return "sku/admin";
    }

    //添加
    @RequestMapping("/add")
    public String getCate(Model model){
        List<Category> category = categoryService.getCateList();
        model.addAttribute("category",category);
        return "sku/add";
    }

    //执行添加操作
    @RequestMapping("/save")
    public String addSkuKey(SkuKey skuKey){
        skuKey.setCreatetime(new Date());
        skuKey.setUpdatetime(new Date());
        skuService.addaddSkuKey(skuKey);
        return "redirect:/sku/admin";
    }

    //删除操作
    @RequestMapping("/delete")
    public String deleteSku(Integer id){
        skuService.deleteSkuById(id);
        return "redirect:/sku/admin";
    }
}
