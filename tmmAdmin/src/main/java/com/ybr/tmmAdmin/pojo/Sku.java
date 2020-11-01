package com.ybr.tmmAdmin.pojo;

import java.util.Date;

public class Sku {
    private Integer id;
    private String key_name;
    private Date createtime;
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public String getKey_name() {
        return key_name;
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

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "id=" + id +
                ", key_name='" + key_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
