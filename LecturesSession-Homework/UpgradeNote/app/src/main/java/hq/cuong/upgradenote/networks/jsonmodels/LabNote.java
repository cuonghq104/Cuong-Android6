package hq.cuong.upgradenote.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Cuong on 12/18/2016.
 */
public class LabNote {

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("color")
    private String color;

    @SerializedName("completed")
    private boolean completed;

    @SerializedName("_id")
    private LabId id;

    public LabNote(String title, String content, String color, boolean completed, LabId id) {
        this.title = title;
        this.content = content;
        this.color = color;
        this.completed = completed;
        this.id = id;
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

    public LabId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "LabNote{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", color='" + color + '\'' +
                ", completed=" + completed +
                ", id=" + id +
                '}';
    }

    private static ArrayList<LabNote> labNotes = new ArrayList<>();

    public static ArrayList<LabNote> getLabNotes() {
        return labNotes;
    }

    public static void setLabNotes(ArrayList<LabNote> labNotes) {
        LabNote.labNotes = labNotes;
    }

    public static void add(LabNote labNote) {
        labNotes.add(labNote);
    }
}
