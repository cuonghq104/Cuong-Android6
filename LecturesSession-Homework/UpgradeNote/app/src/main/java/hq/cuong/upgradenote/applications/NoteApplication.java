package hq.cuong.upgradenote.applications;

import android.app.Application;

import java.util.ArrayList;

//import hq.cuong.upgradenote.databases.DbContext;
import hq.cuong.upgradenote.managers.Preferences;
import hq.cuong.upgradenote.models.Note;

/**
 * Created by Cuong on 12/16/2016.
 */
public class NoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        DbContext.init(this);
//        Note.setNotes((ArrayList<Note>) DbContext.getInstance().getAllNote());
//        for (Note note : DbContext.getInstance().getAllNote()) {
//            Note.add(note);
//        }
        Preferences.init(this);
    }
}
