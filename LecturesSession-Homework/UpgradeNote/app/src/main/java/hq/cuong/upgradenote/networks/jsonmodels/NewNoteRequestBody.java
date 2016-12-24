package hq.cuong.upgradenote.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 12/23/2016.
 */
public class NewNoteRequestBody {
    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("color")
    private String color;

    @SerializedName("completed")
    private boolean completed;

    public NewNoteRequestBody(String title, String content, String color, boolean completed) {
        this.title = title;
        this.content = content;
        this.color = color;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getColor() {
        return color;
    }

    public boolean isCompleted() {
        return completed;
    }
}
