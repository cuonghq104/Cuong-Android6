package com.example.cuong.lab3.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 11/27/2016.
 */
public class HairCatalogue {

    @SerializedName("d")
    private HairStyle[] hairStyles;

    public HairCatalogue(HairStyle[] hairStyles) {
        this.hairStyles = hairStyles;
    }

    public HairStyle[] getHairStyles() {
        return hairStyles;
    }

    public void setHairStyles(HairStyle[] hairStyles) {
        this.hairStyles = hairStyles;
    }
}
