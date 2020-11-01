package com.ybr.tmmAdmin.dao;

import com.ybr.tmmAdmin.pojo.Attr;
import com.ybr.tmmAdmin.pojo.Category;
import com.ybr.tmmAdmin.pojo.CategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {

    /**
     * 查询数据库中分类列表的信息
     * @return
     */
    List<Category> getCateList();


    /**
     * 插入分类类别
     * @param categoryVo
     */
    void insertCate(CategoryVo categoryVo);

    /**
     * 往数据库中品牌分类中间表中插入数据
     * @param brand_id 品牌id
     * @param category_id 分类id
     */
    void insertCateBrand(@Param("brand_id") Integer brand_id, @Param("category_id") Integer category_id);

    /**
     * 从数据库中删除brand_Categories中的信息
     * @param id category_id
     */
    void deleteCateBrandById(@Param("category_id") Integer id);

    /**
     * 从数据库中删除category中的数据
     * @param id 分类id
     */
    void deleteCateById(@Param("id") Integer id);

    /**
     * 根据分类id去数据库中查找相应的分类信息
     * @param id 分类id
     * @return
     */
    Category getCateById(@Param("id") Integer id);

    /**
     * 根据页面传来的实体对象去修改数据库中的分类信息
     * @param category 页面传来的实体对象
     */
    void updateCate(Category category);

    /**
     * 根据商品分类id删除商品
     * @param id 分类id
     */
    void deleteSpuById(@Param("spu_category_id") Integer id);

    /**
     * 根据分类id删除属性键的id
     * @param id 属性键id
     */
    void deleteKeyById(@Param("category_id") Integer id);

    /**
     * 根据属性键的id获取属性值
     * @param id 属性键id
     * @return
     */
    List<Attr> getAttrBySkuId(@Param("key_id") Integer id);
}
