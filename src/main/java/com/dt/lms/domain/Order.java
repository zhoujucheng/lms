package com.dt.lms.domain;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer goodId;

    private String goodName;

    private Double price;

    private String suporre;

    private Date time;

    private int type;

    public Order(Integer goodId, String goodName, Double price, String suporre, Date time,int type) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.price = price;
        this.suporre = suporre;
        this.time = time;
        this.type = type;
    }

    public Order(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSuporre() {
        return suporre;
    }

    public void setSuporre(String suporre) {
        this.suporre = suporre == null ? null : suporre.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}