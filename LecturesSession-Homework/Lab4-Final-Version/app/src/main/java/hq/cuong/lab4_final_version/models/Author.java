package hq.cuong.lab4_final_version.models;

/**
 * Created by Cuong on 12/5/2016.
 */
public class Author {

    private String url;

    private String name;

    public Author(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
