package com.ybr.tmmAdmin.Service.Impl;

import com.ybr.tmmAdmin.Service.SkuService;
import com.ybr.tmmAdmin.Service.SpuService;
import com.ybr.tmmAdmin.dao.SkuDao;
import com.ybr.tmmAdmin.dao.SpuDao;
import com.ybr.tmmAdmin.pojo.Sku;
import com.ybr.tmmAdmin.pojo.SkuKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {


    @Autowired
    private SkuDao skuDao;
    @Autowired
    private SpuDao spuDao;

    private SpuService spuService;

    @Override
    public List<Sku> getSkuList() {
        return skuDao.getSkuList();
    }

    @Override
    public void addaddSkuKey(SkuKey skuKey) {
        //先添加属性键
        skuDao.insertSku(skuKey);
        //再根据当前属性键的id，往属性键和分类的中间表插入数据
        skuDao.insertSkuCate(skuKey.getId(),skuKey.getCategory_id());
    }

    @Override
    public void deleteSkuById(Integer id) {
        //先删除当前属性键id所在的分类属性键中间表信息
        skuDao.deleteSkuCateById(id);
        //删除属性键对应的属性值数据
        skuDao.deleteAttrById(id);
        //然后删除属性键表中的属性键
        skuDao.deleteSkuById(id);
    }

    @Override
    public List<SkuKey> getSkuByCateId(Integer id) {
        return skuDao.getSkuByCateId(id);
    }

    @Override
    public List<SkuKey> getSkuByCId(Integer id) {
        List<SkuKey> skuKeys=skuDao.getSkuByCateId(id);
        return null;
    }
}
