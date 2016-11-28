package com.example.cuong.lab3.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 11/28/2016.
 */
public class Account {

    @SerializedName("Id")
    private int id;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("CustomerName")
    private String customerName;

    @SerializedName("Email")
    private String email;

    @SerializedName("DayOfBirth")
    private int dayOfBirth;

    @SerializedName("MonthOfBirth")
    private int monthOfBirth;

    @SerializedName("YearOfBirth")
    private int yearOfBirth;

    @SerializedName("AccessToken")
    private String accessToken;

    public Account(int id, String phone, String customerName, String email, int dayOfBirth, int monthOfBirth, int yearOfBirth, String accessToken) {
        this.id = id;
        this.phone = phone;
        this.customerName = customerName;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.accessToken = accessToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Account{" +
                "\n\t\tphone='" + phone + '\'' +
                ",\n\t\t customerName='" + customerName + '\'' +
                ",\n\t\t email='" + email + '\'' +
                ",\n\t\t dayOfBirth=" + dayOfBirth +
                ",\n\t\t monthOfBirth=" + monthOfBirth +
                ",\n\t\t yearOfBirth=" + yearOfBirth +
                ",\n\t\t accessToken='" + accessToken + '\'' +
                "\n\t}";
    }
}
