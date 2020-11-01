package com.ybr.tmmAdmin.pojo;

import java.util.Date;

public class CategoryVo {
    private Integer id;
    private String cate_name;
    private Date createtime;
    private Date updatetime;
    private Integer brand_id;
    private Integer category_id;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getId() {
        return id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", cate_name='" + cate_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", brand_id=" + brand_id +
                ", category_id=" + category_id +
                '}';
    }
}
