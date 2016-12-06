package hq.cuong.lab4_final_version.models;

/**
 * Created by Cuong on 12/5/2016.
 */
public class Item {

    private String phone;

    private Image[] images;

    private String name;

    private String website;

    public Item(String phone, Image[] images, String name, String website) {
        this.phone = phone;
        this.images = images;
        this.name = name;
        this.website = website;
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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
