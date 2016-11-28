package com.example.cuong.lab3.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Cuong on 11/27/2016.
 */
public class SalonGroup {

    @SerializedName("d")
    private HairSalon[] salonGroup;

    public SalonGroup(HairSalon[] salonGroup) {
        this.salonGroup = salonGroup;
    }

    public HairSalon[] getSalonGroup() {
        return salonGroup;
    }

    public void setSalonGroup(HairSalon[] salonGroup) {
        this.salonGroup = salonGroup;
    }

    @Override
    public String toString() {
        return "SalonGroup{" +
                "salonGroup=" + Arrays.toString(salonGroup) +
                '}';
    }
}
