package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.pojo.Spu;
import com.ybr.tmmAdmin.pojo.SpuVo;

import java.util.List;

public interface SpuService {
    /**
     * 从数据库获取商品信息
     */
    List<Spu> getSpuList();

    /**
     * 根据商品id更改状态
     * @param id 商品id
     */
    void updateStatus(Integer id);

    /**
     * 根据商品id删除商品
     * @param id 商品id
     */
    void deleteSpu(Integer id);

    /**
     * 获取添加商品页面信息
     * @return
     */
    SpuVo getSpu();

    /**
     * 根据页面传来的实体类添加商品
     * @param spuVo 页面传来的实体类
     */
    void addSpu(SpuVo spuVo);

    /**
     * 根据选择的商品id获取当前商品的信息
     * @param id 当前的商品id
     * @return
     */
    SpuVo getSpuById(Integer id);

    /**
     * 根据页面传来的数据更新商品信息
     * @param spuVo 页面传来的数据实体
     */
    void updateSpu(SpuVo spuVo);
}
