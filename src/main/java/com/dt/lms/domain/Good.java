package com.dt.lms.domain;

public class Good {
    private Integer id;

    private String name;

    private Integer amount;

    private Double inprice;

    private Double outprice;

    private String type;

    public Good(){}

    public Good(Integer id, String name, Integer amount, Double inprice, Double outprice, String type) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.inprice = inprice;
        this.outprice = outprice;
        this.type = type;
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}