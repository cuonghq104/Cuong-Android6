package com.example.cuong.lab3.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 11/28/2016.
 */
public class Customer {

    @SerializedName("Phone")
    private String phone;

    @SerializedName("CustomerName")
    private String customerName;

    @SerializedName("Email")
    private String email;

    @SerializedName("Password")
    private String password;

    @SerializedName("DayOfBirth")
    private int dayOfBirth;

    @SerializedName("MonthOfBirth")
    private int monthOfBirth;

    @SerializedName("YearOfBirth")
    private int yearOfBirth;

    public Customer(String phone, String customerName, String email, String password, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.phone = phone;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Customer{" +
                "phone='" + phone + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
