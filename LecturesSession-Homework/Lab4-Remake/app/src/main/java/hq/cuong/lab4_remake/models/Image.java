package hq.cuong.lab4_remake.models;

/**
 * Created by Cuong on 12/4/2016.
 */
public class Image {
    private String type;

    private String url;

    public Image(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
