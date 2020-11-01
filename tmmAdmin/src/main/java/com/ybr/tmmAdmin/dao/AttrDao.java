package com.ybr.tmmAdmin.dao;

import com.ybr.tmmAdmin.pojo.Attr;
import com.ybr.tmmAdmin.pojo.AttrVo;
import com.ybr.tmmAdmin.pojo.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttrDao {

    /**
     * 从数据库中获取属性值列表
     * @return
     */
    List<Attr> getAttrList();

    /**
     * 往数据库中插入属性值
     * @param attrVo 属性实体
     */
    void insertValue(AttrVo attrVo);




    /**
     * 根据属性值id删除属性值
     * @param id 属性值id
     */
    void deleteAttr(@Param("id") Integer id);

    /**
     * 根据属性值id去数据库查询属性值
     * @param id 属性值id
     * @return
     */
    AttrVo getAttrById(@Param("id") Integer id);

    /**
     * 根据属性值的id去数据库中查找属性键
     * @param id 属性值id
     * @return
     */
    Sku getSkuByAttrId(@Param("id") Integer id);

    /**
     * 根据页面传来的属性值信息修改属性值
     * @param attrVo 属性值实体信息
     */
    void updateAttr(AttrVo attrVo);
}
