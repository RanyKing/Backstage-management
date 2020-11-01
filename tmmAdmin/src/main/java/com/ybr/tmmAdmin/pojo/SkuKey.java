package com.ybr.tmmAdmin.pojo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SkuKey {
    private Integer category_id;
    private Integer id;
    private String key_name;
    private Date createtime;
    private Date updatetime;
    private List<Attr> attrList;
    private Integer[] yids;

    public Integer[] getYids() {
        return yids;
    }

    public void setYids(Integer[] yids) {
        this.yids = yids;
    }

    public List<Attr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<Attr> attrList) {
        this.attrList = attrList;
    }

    public Integer getCategory_id() {
        return category_id;
    }

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

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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
        return "SkuKey{" +
                "category_id=" + category_id +
                ", id=" + id +
                ", key_name='" + key_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", attrList=" + attrList +
                ", yids=" + Arrays.toString(yids) +
                '}';
    }
}
