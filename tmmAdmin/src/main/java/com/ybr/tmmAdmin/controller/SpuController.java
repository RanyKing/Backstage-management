package com.ybr.tmmAdmin.controller;

import com.alibaba.fastjson.JSON;
import com.ybr.tmmAdmin.Service.BrandService;
import com.ybr.tmmAdmin.Service.SkuService;
import com.ybr.tmmAdmin.Service.SpuService;
import com.ybr.tmmAdmin.pojo.SkuKey;
import com.ybr.tmmAdmin.pojo.Spu;
import com.ybr.tmmAdmin.pojo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;
    @Autowired
    private SkuService skuService;


    //首页
    @RequestMapping("/admin")
    public String getSpuList(Model model){
        List<Spu> spuList = spuService.getSpuList();
        model.addAttribute("spuList",spuList);
        return "spu/admin";
    }

    //更改状态
    @RequestMapping("/status")
    public String statusById(Integer id){
        //根据当前选择的商品id改变状态
        spuService.updateStatus(id);
        return "redirect:/spu/admin";
    }

    //删除操作
    @RequestMapping("/delete")
    public String deleteSpuById(Integer id){
        spuService.deleteSpu(id);
        return "redirect:/spu/admin";
    }

    //添加
    @RequestMapping("/add")
    public String addSpu(Model model){
        SpuVo spuVo = spuService.getSpu();
        model.addAttribute("spuVo",spuVo);
        return "spu/add";
    }

    //执行添加操作
    @RequestMapping("/save")
    public String insertSpu(SpuVo spuVo){
        spuVo.setCreatetime(new Date());
        spuVo.setUpdatetime(new Date());
        spuService.addSpu(spuVo);
        System.out.println(spuVo);
        return "redirect:/spu/admin";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(MultipartFile listfile){
        System.out.println(listfile.getOriginalFilename());
        try {
            listfile.transferTo(new File("D:\\logo\\"+listfile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功！";
    }


    //根据分类的id获取属性键值
    @RequestMapping("/get")
    @ResponseBody
    public String  getSpuAttrKeys(Integer id){ //根据分类的id获取所有的key的集合
        //获取数据库里面所有的key以及所有的values
        List<SkuKey> list=skuService.getSkuByCateId(id);
        String str= JSON.toJSONString(list);
        System.out.println(str);
        return str;
    }

    //修改
    @RequestMapping("/update")
    public String updateSpuById(Integer id,Model model){
        //获取当前id的商品信息
        SpuVo spuVo = spuService.getSpuById(id);
        model.addAttribute("spuVo",spuVo);
        return "spu/update";
    }

    //执行修改操作
    @RequestMapping("alter")
    public String update(SpuVo spuVo){
        spuVo.setUpdatetime(new Date());
        spuService.updateSpu(spuVo);
        return "redirect:/spu/admin";
    }

}
