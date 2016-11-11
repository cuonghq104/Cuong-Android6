package com.example.cuong.simplenote.models;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Cuong on 11/11/2016.
 */
public class Note implements Serializable{
    private String content;

    public static final int OP_ADD = 0;
    public static final int OP_UPDATE = 1;

    public static final String OPERATION_KEY = "operation_key";

    public Note(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "" + content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static Vector<Note> noteVector = new Vector<>();

}
