package hq.cuong.lab5.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Cuong on 12/11/2016.
 */
public class HomeContent extends RealmObject {
    @SerializedName("Id")
    private int id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Description")
    private String description;

    @SerializedName("Thumb")
    private Thumb thumb;

    public HomeContent(int id, String name, String description, Thumb thumb) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumb = thumb;
    }

    public HomeContent() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Thumb getThumb() {
        return thumb;
    }

    @Override
    public String toString() {
        return "HomeContent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumb=" + thumb +
                '}';
    }
}
