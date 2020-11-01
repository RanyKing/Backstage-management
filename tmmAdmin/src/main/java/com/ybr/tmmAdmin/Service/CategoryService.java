package com.ybr.tmmAdmin.Service;

import com.ybr.tmmAdmin.pojo.Category;
import com.ybr.tmmAdmin.pojo.CategoryVo;

import java.util.List;

public interface CategoryService {

    /**
     * 获取分类列表
     * @return
     */
    List<Category> getCateList();


    /**
     * 添加分类
     * @param categoryVo 分类实体
     */
    void insertCate(CategoryVo categoryVo);

    /**
     * 删除当前id的分类信息
     * @param id 当前分类的id
     */
    void deleteCateById(Integer id);

    /**
     * 根据分类id获取分类信息
     * @param id 分类id
     * @return
     */
    Category getCateById(Integer id);

    /**
     * 根据页面传来的实体对象修改分类信息
     * @param category 页面传来的实体对象
     */
    void updateCate(Category category);
}
