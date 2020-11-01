package com.ybr.tmmAdmin.Service.Impl;

import com.ybr.tmmAdmin.Service.BrandService;
import com.ybr.tmmAdmin.dao.BrandDao;
import com.ybr.tmmAdmin.pojo.Brand;
import com.ybr.tmmAdmin.pojo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;
    @Override
    public List<Brand> getBrandList() {
        return brandDao.getBrandList();
    }

    @Override
    public void insertBrand(BrandVo brandVo) {
        brandDao.insertBrand(brandVo);
        System.out.println(brandVo);
        //如果分类id不为空那么执行中间表的插入
        if(brandVo.getCategory_id()!=null){
        brandDao.insertBrandCate(brandVo.getId(),brandVo.getCategory_id());
        }
    }

    @Override
    public void deleteBrandById(Integer id) {
        brandDao.deleteBrandCate(id);
        brandDao.deleteBrandById(id);
        //删除商品
        brandDao.deleteSpuById(id);
    }

    @Override
    public Brand searchBrandById(Integer id) {
        return brandDao.searchBrandById(id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDao.updateBrand(brand);
    }
}
