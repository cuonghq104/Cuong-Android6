package com.example.cuong.lab3.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 11/28/2016.
 */
public class CustomerAccountHolder {

    @SerializedName("d")
    private Account account;

    public CustomerAccountHolder(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CustomerAccountHolder{" +
                "\n\tcustomer=" + account +
                "\n}";
    }
}
