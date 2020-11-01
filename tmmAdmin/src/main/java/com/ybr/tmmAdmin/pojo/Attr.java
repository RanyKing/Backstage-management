package com.ybr.tmmAdmin.pojo;

import java.util.Date;

public class Attr {
    private Integer id;
    private String value_name;
    private Date createtime;
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public String getValue_name() {
        return value_name;
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

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Attr{" +
                "id=" + id +
                ", value_name='" + value_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
