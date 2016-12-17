package hq.cuong.upgradenote.models;

import java.util.ArrayList;

import io.realm.RealmObject;

/**
 * Created by Cuong on 12/16/2016.
 */
public class Note extends RealmObject{

    private String title;

    private String content;

    private int color;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getColor() {
        return color;
    }

    public Note() {
    }

    public static Note createNote(String title, String content, int color) {
        Note note = new Note();
        note.title = title;
        note.content = content;
        note.color = color;
        return note;
    }
    private static ArrayList<Note> notes = new ArrayList<>();

    public static ArrayList<Note> getNotes() {
        return notes;
    }

    public static void add(Note note) {
        notes.add(note);
    }

    public static void setNotes(ArrayList<Note> notes) {
        Note.notes = notes;
    }
}
