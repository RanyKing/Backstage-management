package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.pojo.Attr;
import com.ybr.tmmAdmin.pojo.AttrVo;
import com.ybr.tmmAdmin.pojo.Sku;

import java.util.List;

public interface AttrService {
    /**
     * 获取属性值列表
     * @return
     */
    List<Attr> getAttrList();

    /**
     * 根据页面实体进行添加属性值
     * @param attrVo 页面实体
     */
    void addValue(AttrVo attrVo);

    /**
     * 根据id删除属性值
     * @param id 属性值的id
     */
    void deleteAttr(Integer id);

    /**
     * 根据属性值id查询当前属性值的信息
     * @param id 属性值id
     * @return
     */
    AttrVo getAttrById(Integer id);

    /**
     * 根据属性值id查找属性键
     * @param id 属性值id
     * @return
     */
    Sku getSkuByAttrId(Integer id);

    /**
     * 根据页面传来的实体信息修改属性值
     * @param attrVo 实体信息
     */
    void updateAttr(AttrVo attrVo);
}
