package com.ybr.tmmAdmin.dao;

import com.ybr.tmmAdmin.pojo.Attr;
import com.ybr.tmmAdmin.pojo.Spu;
import com.ybr.tmmAdmin.pojo.SpuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuDao {

    /**
     * 获取商品列表
     */
    List<Spu> getSpuList();

    /**
     * 根据商品id查寻该商品的状态值
     * @param id 商品id
     * @return
     */
    Integer getSpuStatus(@Param("id") Integer id);

    /**
     * 将改商品的状态值改为1
     * @param id 商品id
     */
    void status1ById(@Param("id") Integer id);

    /**
     * 将该商品的状态值改为0
     * @param id 商品id
     */
    void status0ById(@Param("id") Integer id);

    /**
     * 根据商品id删除当前的商品
     * @param id 商品id
     */
    void deleteSpu(Integer id);

    /**
     * 根据商品id删除规格表中的数据
     * @param id 商品id
     */
    void deleteguige(@Param("sku_spu_id") Integer id);

    /**
     * 往数据库商品表中添加商品
     * @param spuVo 页面传来的商品实体
     */
    void addSpu(SpuVo spuVo);

    /**
     * 根据商品id删除属性值中间表信息
     * @param id 商品id
     */
    void deleteAttrSpu(@Param("id") Integer id);

    /**
     * 往数据库的商品属性值中间表中插入数据
     * @param id 商品id
     * @param spu_attr_value_ids 属性值id数组
     */
    void addSpuAttr(@Param("spu_id") Integer id, @Param("spu_attr_value_ids") Integer[] spu_attr_value_ids);

    /**
     * 根据商品id获取商品的信息
     * @param id 商品id
     * @return
     */
    SpuVo getSpuById(@Param("id") Integer id);


    /**
     * 根据商品id查询属性值
     * @param id 商品id
     * @return
     */
    List<Attr> getAttrsByIds(@Param("id") Integer id);

    /**
     * 根据页面信息更改数据库中商品信息
     * @param spuVo
     */
    void update(SpuVo spuVo);
}
