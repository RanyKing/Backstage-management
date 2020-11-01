package com.ybr.tmmAdmin.pojo;

import java.util.Date;

public class Category {
    private Integer id;
    private String cate_name;
    private Date createtime;
    private Date updatetime;
    private Integer parent_id;

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

    public Integer getParent_id() {
        return parent_id;
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

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cate_name='" + cate_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", parent_id=" + parent_id +
                '}';
    }

}
