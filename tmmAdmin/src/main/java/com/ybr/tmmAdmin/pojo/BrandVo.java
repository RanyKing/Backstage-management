package com.ybr.tmmAdmin.pojo;

import java.util.Arrays;
import java.util.Date;

public class BrandVo {
    private Integer id;
    private String brand_name;
    private String brand_introduction;
    private String  brand_logourl;
    private Date createtime;
    private Date updatetime;
    private Integer category_id;
    private String cate_name;
    private Integer parent_id;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }



    public Integer getId() {
        return id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getBrand_introduction() {
        return brand_introduction;
    }

    public String getBrand_logourl() {
        return brand_logourl;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public void setBrand_introduction(String brand_introduction) {
        this.brand_introduction = brand_introduction;
    }

    public void setBrand_logourl(String brand_logourl) {
        this.brand_logourl = brand_logourl;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "BrandVo{" +
                "id=" + id +
                ", brand_name='" + brand_name + '\'' +
                ", brand_introduction='" + brand_introduction + '\'' +
                ", brand_logourl='" + brand_logourl + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", category_id=" + category_id +
                ", cate_name='" + cate_name + '\'' +
                ", parent_id=" + parent_id +
                '}';
    }
}
