package hq.cuong.lab5.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Cuong on 12/11/2016.
 */
public class Thumb extends RealmObject {

    @SerializedName("url")
    private String url;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    public Thumb(String url, String thumb, String title, String description) {
        this.url = url;
        this.thumb = thumb;
        this.title = title;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Thumb() {
    }

    @Override
    public String toString() {
        return "Thumb{" +
                "url='" + url + '\'' +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
