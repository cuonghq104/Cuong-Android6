package com.example.cuong.foodysimple.models;

/**
 * Created by Cuong on 11/24/2016.
 */
public class Food {

    private String name;

    private String detail;

    private String image;

    private int price;

    public Food(String name, String detail, String image, int price) {
        this.name = name;
        this.detail = detail;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageUrl) {
        this.image = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
