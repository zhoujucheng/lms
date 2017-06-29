package com.dt.lms.domain;

import java.util.Date;

public class Order {

    private Integer id;

    private int goodId;

    private String goodName;

    private int amount;

    private Double price;

    private String supOrRe;

    private Date time;

    private int type;

    public Order(Integer goodId, String goodName,int amount, Double price, String supOrRe, Date time,int type) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.amount = amount;
        this.price = price;
        this.supOrRe = supOrRe;
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

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSupOrRe() {
        return supOrRe;
    }

    public void setSupOrRe(String supOrRe) {
        this.supOrRe = supOrRe;
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