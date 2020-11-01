package com.ybr.tmmAdmin.controller;

import com.ybr.tmmAdmin.Service.AttrService;
import com.ybr.tmmAdmin.Service.SkuService;
import com.ybr.tmmAdmin.dao.AttrDao;
import com.ybr.tmmAdmin.pojo.Attr;
import com.ybr.tmmAdmin.pojo.AttrVo;
import com.ybr.tmmAdmin.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
    private SkuService skuService;


    @RequestMapping("/admin")
    public String getAttrList(Model model){
        List<Attr> attrList = attrService.getAttrList();
        model.addAttribute("attrList",attrList);
        return "attr/admin";
    }

    //添加
    @RequestMapping("/add")
    public String addKeyValue(Model model){
        List<Sku> skuList = skuService.getSkuList();
        model.addAttribute("skuList",skuList);
        return "attr/add";
    }

    //执行添加操作
    @RequestMapping("/save")
    public String addValue(AttrVo attrVo){
        attrVo.setCreatetime(new Date());
        attrVo.setUpdatetime(new Date());
        attrService.addValue(attrVo);
        return "redirect:/attr/admin";
    }

    //执行删除操作
    @RequestMapping("/delete")
    public String deleteAttr(Integer id){
        //根据id删除属性值
        attrService.deleteAttr(id);
        return "redirect:/attr/admin";
    }

    //修改
    @RequestMapping("/update")
    public String getKey(Integer id,Model model){
        //查找当前的属性值的信息
        AttrVo attrVo = attrService.getAttrById(id);
        //获取属性键列表
        List<Sku> skuList = skuService.getSkuList();
        //根据当前的属性值id查找当前属性值对应的属性键
        Sku sku = attrService.getSkuByAttrId(id);
        model.addAttribute("attrVo",attrVo);
        model.addAttribute("skuList",skuList);
        model.addAttribute("sku",sku);
        return "attr/update";
    }

    //执行修改操作
    @RequestMapping("/alter")
    public String alter(AttrVo attrVo){
        attrVo.setUpdatetime(new Date());
        attrService.updateAttr(attrVo);
        System.out.println(attrVo);
        return "redirect:/attr/admin";
    }
}
