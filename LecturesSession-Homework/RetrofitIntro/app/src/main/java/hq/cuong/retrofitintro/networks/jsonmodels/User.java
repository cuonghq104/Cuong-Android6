package hq.cuong.retrofitintro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 12/6/2016.
 */
public class User {


    @SerializedName("Email")
    private String email;

    @SerializedName("AccessToken")
    private String accessToken;

    @SerializedName("DayOfBirth")
    private int dayOfBirth;

    @SerializedName("MonthOfBirth")
    private int monthOfBirth;

    @SerializedName("YearOfBirth")
    private int yearOfBirth;

    @SerializedName("Phone")
    private int phone;

    @SerializedName("CustomerName")
    private String customerName;

    @SerializedName("Id")
    private int id;

    public User(String email, String accessToken, int dayOfBirth, int monthOfBirth, int yearOfBirth, int phone, String customerName, int id) {
        this.email = email;
        this.accessToken = accessToken;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.phone = phone;
        this.customerName = customerName;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
