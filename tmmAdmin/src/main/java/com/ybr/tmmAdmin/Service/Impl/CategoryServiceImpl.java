package com.ybr.tmmAdmin.Service.Impl;

import com.ybr.tmmAdmin.Service.CategoryService;
import com.ybr.tmmAdmin.dao.AttrDao;
import com.ybr.tmmAdmin.dao.CategoryDao;
import com.ybr.tmmAdmin.dao.SkuDao;
import com.ybr.tmmAdmin.dao.SpuDao;
import com.ybr.tmmAdmin.pojo.Category;
import com.ybr.tmmAdmin.pojo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCateList() {
        return categoryDao.getCateList();
    }

    @Override
    public void insertCate(CategoryVo categoryVo) {
        //先插入分类类别
        categoryDao.insertCate(categoryVo);
        //插入中间表数据
        System.out.println(categoryVo);
        categoryDao.insertCateBrand(categoryVo.getBrand_id(),categoryVo.getCategory_id());
    }

    @Override
    public void deleteCateById(Integer id) {
        //首先根据当前的分类id删除中间表中的信息
        //1.删除品牌分类表中的信息
        categoryDao.deleteCateBrandById(id);
        //2.删除当前分类的属性键信息
        categoryDao.deleteKeyById(id);
        //3.删除当前分类的商品信息
        categoryDao.deleteSpuById(id);
        //再删除当前的分类
        categoryDao.deleteCateById(id);
    }

    @Override
    public Category getCateById(Integer id) {
        return categoryDao.getCateById(id);
    }

    @Override
    public void updateCate(Category category) {
        categoryDao.updateCate(category);
    }


}
