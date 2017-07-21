package com.zcy.OneToOne.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zcy on 2017/7/21.
 */
public class Article implements Serializable {
    private Integer id; //商品id，主键
    private String name;//商品名称
    private String price;//商品价格
    private String remark; //商品描述

    //商品和订单是多对多的关系，即一种商品可以出现多个订单中
    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", remark='" + remark + '\'' +
                ", orders=" + orders +
                '}';
    }
}
