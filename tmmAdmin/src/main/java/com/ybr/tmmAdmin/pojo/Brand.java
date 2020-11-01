package com.ybr.tmmAdmin.pojo;


import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Brand {
    private Integer id;
    private String brand_name;
    private String brand_introduction;
    private String  brand_logourl;
    private Date createtime;
    private Date updatetime;

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

    public void setBrand_logourl(String brand_logourl) {
        this.brand_logourl = brand_logourl;
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



    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand_name='" + brand_name + '\'' +
                ", brand_introduction='" + brand_introduction + '\'' +
                ", brand_logourl=" + brand_logourl +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
