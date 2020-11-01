package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.pojo.Brand;
import com.ybr.tmmAdmin.pojo.BrandVo;

import java.util.List;

public interface BrandService {

    /**
     * 获取品牌列表
     * @return
     */
    List<Brand> getBrandList();

    /**
     * 插入买新的品牌
     * @param brandVo
     */
    void insertBrand(BrandVo brandVo);

    /**
     * 根据品牌id来删除品牌
     * @param id
     */
    void deleteBrandById(Integer id);

    /**
     * 根据id查找当前要修改的品牌信息
     * @param id 当前要修改的品牌id
     * @return
     */
    Brand searchBrandById(Integer id);

    /**
     * 修改brand信息
     * @param brand
     */
    void updateBrand(Brand brand);
}
