package com.example.cuong.lab3.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 11/27/2016.
 */
public class HairStyle {

    @SerializedName("Description")
    private String description;

    @SerializedName("Id")
    private String id;

    @SerializedName("Images")
    private Image[] images;

    @SerializedName("Title")
    private String title;

    public HairStyle(String description, String id, Image[] images, String title) {
        this.description = description;
        this.id = id;
        this.images = images;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImages() {
        return images[0];
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
