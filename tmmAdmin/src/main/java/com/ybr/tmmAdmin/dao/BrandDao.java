package com.ybr.tmmAdmin.dao;

import com.ybr.tmmAdmin.pojo.Brand;
import com.ybr.tmmAdmin.pojo.BrandVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDao {

    /**
     * 获取品牌列表
     * @return
     */
    List<Brand> getBrandList();

    /**
     * 往数据库中插入一条新的品牌
     * @param brandVo
     */
    void insertBrand(BrandVo brandVo);

    /**
     * 根据品牌id来删除品牌
     * @param id
     */
    void deleteBrandById(@Param("id") Integer id);

    /**
     * 根据id查找当前要修改的品牌信息
     * @param id 品牌id
     * @return
     */
    Brand searchBrandById(@Param("id") Integer id);

    /**
     * 根据前台传来的brand信息更改信息
     * @param brand
     */
    void updateBrand(Brand brand);

    /**
     * 往数据库插入中间表信息
     * @param id 品牌id
     * @param category_id 分类id
     */
    void insertBrandCate(@Param("brand_id") Integer id, @Param("category_id") Integer category_id);

    /**
     * 根据品牌id删除中间表的数据
     * @param id 品牌id
     */
    void deleteBrandCate(@Param("brand_id") Integer id);

    /**
     * 根据品牌id删除商品
     * @param id
     */
    void deleteSpuById(@Param("id") Integer id);
}
