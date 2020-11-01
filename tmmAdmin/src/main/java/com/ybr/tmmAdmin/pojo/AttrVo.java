package com.ybr.tmmAdmin.pojo;

import java.util.Date;

public class AttrVo {
    private Integer id;
    private String value_name;
    private Date createtime;
    private Date updatetime;
    private Integer key_id;

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

    public Integer getKey_id() {
        return key_id;
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

    public void setKey_id(Integer key_id) {
        this.key_id = key_id;
    }

    @Override
    public String toString() {
        return "AttrVo{" +
                "id=" + id +
                ", value_name='" + value_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", key_id=" + key_id +
                '}';
    }
}
