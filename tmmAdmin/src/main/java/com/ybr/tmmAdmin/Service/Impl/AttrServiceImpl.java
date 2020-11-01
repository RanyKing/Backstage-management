package com.ybr.tmmAdmin.Service.Impl;

import com.ybr.tmmAdmin.Service.AttrService;
import com.ybr.tmmAdmin.dao.AttrDao;
import com.ybr.tmmAdmin.pojo.Attr;
import com.ybr.tmmAdmin.pojo.AttrVo;
import com.ybr.tmmAdmin.pojo.Sku;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrDao attrDao;
    @Override
    public List<Attr> getAttrList() {
        return attrDao.getAttrList();
    }

    @Override
    public void addValue(AttrVo attrVo) {
        attrDao.insertValue(attrVo);
    }

    @Override
    public void deleteAttr(Integer id) {

        //再根据id删除属性值
        attrDao.deleteAttr(id);

    }

    @Override
    public AttrVo getAttrById(Integer id) {
        return attrDao.getAttrById(id);
    }

    @Override
    public Sku getSkuByAttrId(Integer id) {
        return attrDao.getSkuByAttrId(id);
    }

    @Override
    public void updateAttr(AttrVo attrVo) {
        attrDao.updateAttr(attrVo);
    }
}
