package com.ybr.tmmAdmin.pojo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SpuVo {
    private Integer id;
    private List<Brand> brandList;
    private List<Category> categoryList;
    private String spu_name;
    private String spu_thumburl;
    private Double spu_price;
    private String spu_title;
    private String spu_introduction;
    private Integer spu_warningstock;
    private Integer spu_maxbuy;
    private String spu_unit;
    private Date createtime;
    private Date updatetime;
    private Integer spu_brand_id;
    private Integer spu_category_id;
    private Integer[] spu_attr_value_ids;
    private Integer[] yids;
    private List<Attr> yattr;

    public Integer getId() {
        return id;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public String getSpu_thumburl() {
        return spu_thumburl;
    }

    public Double getSpu_price() {
        return spu_price;
    }

    public String getSpu_title() {
        return spu_title;
    }

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public Integer getSpu_warningstock() {
        return spu_warningstock;
    }

    public Integer getSpu_maxbuy() {
        return spu_maxbuy;
    }

    public String getSpu_unit() {
        return spu_unit;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public Integer getSpu_brand_id() {
        return spu_brand_id;
    }

    public Integer getSpu_category_id() {
        return spu_category_id;
    }

    public Integer[] getSpu_attr_value_ids() {
        return spu_attr_value_ids;
    }

    public Integer[] getYids() {
        return yids;
    }

    public List<Attr> getYattr() {
        return yattr;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public void setSpu_thumburl(String spu_thumburl) {
        this.spu_thumburl = spu_thumburl;
    }

    public void setSpu_price(Double spu_price) {
        this.spu_price = spu_price;
    }

    public void setSpu_title(String spu_title) {
        this.spu_title = spu_title;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    public void setSpu_warningstock(Integer spu_warningstock) {
        this.spu_warningstock = spu_warningstock;
    }

    public void setSpu_maxbuy(Integer spu_maxbuy) {
        this.spu_maxbuy = spu_maxbuy;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public void setSpu_brand_id(Integer spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
    }

    public void setSpu_category_id(Integer spu_category_id) {
        this.spu_category_id = spu_category_id;
    }

    public void setSpu_attr_value_ids(Integer[] spu_attr_value_ids) {
        this.spu_attr_value_ids = spu_attr_value_ids;
    }

    public void setYids(Integer[] yids) {
        this.yids = yids;
    }

    public void setYattr(List<Attr> yattr) {
        this.yattr = yattr;
    }

    @Override
    public String toString() {
        return "SpuVo{" +
                "id=" + id +
                ", brandList=" + brandList +
                ", categoryList=" + categoryList +
                ", spu_name='" + spu_name + '\'' +
                ", spu_thumburl='" + spu_thumburl + '\'' +
                ", spu_price=" + spu_price +
                ", spu_title='" + spu_title + '\'' +
                ", spu_introduction='" + spu_introduction + '\'' +
                ", spu_warningstock=" + spu_warningstock +
                ", spu_maxbuy=" + spu_maxbuy +
                ", spu_unit='" + spu_unit + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", spu_brand_id=" + spu_brand_id +
                ", spu_category_id=" + spu_category_id +
                ", spu_attr_value_ids=" + Arrays.toString(spu_attr_value_ids) +
                ", yids=" + Arrays.toString(yids) +
                ", yattr=" + yattr +
                '}';
    }
}
