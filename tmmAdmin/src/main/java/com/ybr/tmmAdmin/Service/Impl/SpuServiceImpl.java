package com.ybr.tmmAdmin.Service.Impl;

import com.ybr.tmmAdmin.Service.SpuService;
import com.ybr.tmmAdmin.dao.BrandDao;
import com.ybr.tmmAdmin.dao.CategoryDao;
import com.ybr.tmmAdmin.dao.SpuDao;
import com.ybr.tmmAdmin.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {


    @Autowired
    private SpuDao spuDao;

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Spu> getSpuList() {
        return spuDao.getSpuList();
    }

    @Override
    public void updateStatus(Integer id) {
        //根据当前的商品id查询当前商品的状态值
        Integer status_id = spuDao.getSpuStatus(id);
        //根据商品id和状态id更改状态
        //先进性判断
        if(status_id==0){
            spuDao.status1ById(id);
        }
        if(status_id==1){
            spuDao.status0ById(id);
        }
    }

    @Override
    public void deleteSpu(Integer id) {
        //根据商品id先删除sku表中的数据
        spuDao.deleteguige(id);
        //删除属性值中间表
        spuDao.deleteAttrSpu(id);
        spuDao.deleteSpu(id);
    }

    @Override
    public SpuVo getSpu() {
        SpuVo spuVo= new SpuVo();
        //获取品牌列表
        List<Brand> brandList=brandDao.getBrandList();
        //获取分类列表
        List<Category> categoryList=categoryDao.getCateList();
        spuVo.setBrandList(brandList);
        spuVo.setCategoryList(categoryList);
        return spuVo;
    }

    @Override
    public void addSpu(SpuVo spuVo) {
        spuDao.addSpu(spuVo);
        System.out.println(spuVo);
        //根据商品id和属性值id往商品属性值表中添加数据
        spuDao.addSpuAttr(spuVo.getId(),spuVo.getSpu_attr_value_ids());
    }

    @Override
    public SpuVo getSpuById(Integer id) {
        //先获取商品信息
        SpuVo spuVo = spuDao.getSpuById(id);
        //获取品牌列表
        List<Brand> brandList=brandDao.getBrandList();
        //获取分类列表
        List<Category> categoryList=categoryDao.getCateList();
        spuVo.setBrandList(brandList);
        spuVo.setCategoryList(categoryList);
        List<Attr> attrs = spuDao.getAttrsByIds(id);
        spuVo.setYattr(attrs);
        return spuVo;
    }

    @Override
    public void updateSpu(SpuVo spuVo) {
        spuDao.update(spuVo);
        //删除属性值和商品中间表
        spuDao.deleteAttrSpu(spuVo.getId());
        //重新插入关系数据
        spuDao.addSpuAttr(spuVo.getId(),spuVo.getSpu_attr_value_ids());
    }
}
