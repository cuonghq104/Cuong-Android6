package com.example.cuong.lab3.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Cuong on 11/27/2016.
 */
public class HairSalon {

    @SerializedName("Fanpage")
    private String fanpage;

    @SerializedName("Name")
    private String name;

    @SerializedName("FanpageId")
    private String fanpageId;

    @SerializedName("ManagerName")
    private String managerName;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Images")
    private Image[] images;

    public HairSalon(String fanpage, String name, String fanpageId, String managerName, String phone, Image[] images) {
        this.fanpage = fanpage;
        this.name = name;
        this.fanpageId = fanpageId;
        this.managerName = managerName;
        this.phone = phone;
        this.images = images;
    }

    public String getFanpage() {
        return fanpage;
    }

    public void setFanpage(String fanpage) {
        this.fanpage = fanpage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFanpageId() {
        return fanpageId;
    }

    public void setFanpageId(String fanpageId) {
        this.fanpageId = fanpageId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    @SerializedName("Id")
    private String id;

    @Override
    public String toString() {
        return "HairSalon{" +
                "fanpage='" + fanpage + '\'' +
                ", name='" + name + '\'' +
                ", fanpageId='" + fanpageId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", phone='" + phone + '\'' +
                ", images=" + Arrays.toString(images) +
                ", id='" + id + '\'' +
                '}';
    }
}
