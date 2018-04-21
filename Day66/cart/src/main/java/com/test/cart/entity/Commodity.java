package com.test.cart.entity;

import java.io.Serializable;

public class Commodity implements Serializable {
    private String sku;
    private String name;
    private float price;
    private int num;

    public String getSku() {
        return sku;
    }

    public void setSku(String id) {
        this.sku = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
