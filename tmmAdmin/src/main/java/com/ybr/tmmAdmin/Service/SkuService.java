package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.pojo.Sku;
import com.ybr.tmmAdmin.pojo.SkuKey;

import java.util.List;

public interface SkuService {

    /**
     * 获取到全部的属性键
     * @return
     */
    List<Sku> getSkuList();

    /**
     * 添加属性键
     * @param skuKey 页面传来的实体对象
     */
    void addaddSkuKey(SkuKey skuKey);

    /**
     * 根据选择的属性键id删除属性键
     * @param id 属性键id
     */
    void deleteSkuById(Integer id);

    /**
     * 根据分类id获取分类对应的属性键
     * @param id 分类id
     * @return
     */
    List<SkuKey> getSkuByCateId(Integer id);

    /**
     * 根据分类id获取分类对应的属性键
     * @param id 分类id
     * @return
     */
    List<SkuKey> getSkuByCId(Integer id);
}
