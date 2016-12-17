package hq.cuong.upgradenote.databases;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hq.cuong.upgradenote.models.Note;
import io.realm.Realm;

/**
 * Created by Cuong on 12/16/2016.
 */
public class DbContext {

    private Realm realm;

    private static DbContext instance;

    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new DbContext();
    }


    public DbContext() {
        realm = Realm.getDefaultInstance();
    }

    public void insert(Note note) {
        realm.beginTransaction();
        realm.insert(note);
        realm.commitTransaction();
    }

    public List<Note> getAllNote() {
        return realm.where(Note.class).findAll();
    }
}
