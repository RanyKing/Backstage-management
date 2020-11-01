package com.ybr.tmmAdmin.dao;


import com.ybr.tmmAdmin.pojo.Sku;
import com.ybr.tmmAdmin.pojo.SkuKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuDao {


    /**
     * 在数据库中查找属性键的信息
     * @return
     */
    List<Sku> getSkuList();

    /**
     * 根据页面传来的实体添加属性键
     * @param skuKey 页面实体
     */
    void insertSku(SkuKey skuKey);

    /**
     * 根据插入后的属性键id和选择的分类id添加中间表数据
     * @param id 属性键id
     * @param category_id 分类id
     */
    void insertSkuCate(@Param("id") Integer id, @Param("category_id") Integer category_id);

    /**
     * 根据属性键的id删除属性键分类中间标的数据
     * @param id 属性键id
     */
    void deleteSkuCateById(@Param("spu_attr_key_id") Integer id);

    /**
     * 删除属性键表中的属性键
     * @param id 属性键id
     */
    void deleteSkuById(@Param("id") Integer id);

    /**
     * 根据属性键id删除属性值的数据
     * @param id 属性键id
     */
    void deleteAttrById(@Param("key_id") Integer id);

    /**
     * 根据分类id查找属性键
     * @param id 分类id
     * @return
     */
    List<SkuKey> getSkuByCateId(@Param("category_id") Integer id);
}
