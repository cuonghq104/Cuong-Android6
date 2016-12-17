package hq.cuong.upgradenote.models;

import java.util.ArrayList;

/**
 * Created by Cuong on 12/16/2016.
 */
public class NoteColor {
    private String color;

    public NoteColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    private static final NoteColor[] NOTE_COLORS = new NoteColor[] {
            new NoteColor("Red"),
            new NoteColor("Green"),
            new NoteColor("Blue"),
            new NoteColor("Yellow"),
            new NoteColor("Gray"),
            new NoteColor("Purple"),
    };

    public static NoteColor[] getNoteColors() {
        return NOTE_COLORS;
    }

    @Override
    public String toString() {
        return color;
    }
}
