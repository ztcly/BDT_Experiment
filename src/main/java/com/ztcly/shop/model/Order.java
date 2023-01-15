package com.ztcly.shop.model;

public class Order {
    private String id;

    private String userid;

    private String shopid;

    private String goodid;

    private String goodquility;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid;
    }

    public String getGoodquility() {
        return goodquility;
    }

    public void setGoodquility(String goodquility) {
        this.goodquility = goodquility;
    }
}