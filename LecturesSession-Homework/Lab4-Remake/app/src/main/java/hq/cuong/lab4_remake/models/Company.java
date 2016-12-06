package hq.cuong.lab4_remake.models;

import java.util.ArrayList;

/**
 * Created by Cuong on 12/4/2016.
 */
public class Company {

    private String name;

    private String phone;

    private String website;

    public Company(String name, String phone, String website) {
        this.name = name;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private static ArrayList<Company> companies = new ArrayList<>();

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public static void setCompanies(ArrayList<Company> companies) {
        Company.companies = companies;
    }
}
