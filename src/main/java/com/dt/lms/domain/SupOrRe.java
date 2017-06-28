package com.dt.lms.domain;

public class SupOrRe {
    private Integer id;

    private String name;

    private String phone;

    private String address;

    private String url;

    private int type;

    public SupOrRe(Integer id, String name, String phone, String address, String url,int type) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.url = url;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}