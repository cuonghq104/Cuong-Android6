package hq.cuong.lab4_remake.models;

import java.util.Arrays;

/**
 * Created by Cuong on 12/4/2016.
 */
public class Item {
    private String name;

    private String website;

    private Image[] images;

    private String phone;

    public Item(String name, String website, Image[] images, String phone) {
        this.name = name;
        this.website = website;
        this.images = images;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", images=" + Arrays.toString(images) +
                ", phone='" + phone + '\'' +
                '}';
    }
}
