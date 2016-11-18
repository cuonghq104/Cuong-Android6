package com.example.cuong.session5_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cuong.session5_sqlite.managers.DbHelper;
import com.example.cuong.session5_sqlite.models.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        this.dbHelper  = DbHelper.getInstance();

        testInsert();

        testDelete();

        testUpdate();

        testSelectAll();

        testSelectRandom();
    }

    private void testSelectRandom() {
        Note note = dbHelper.selectRandomNote();
        Log.d(TAG, String.format("Random note : %s", note.toString()));
    }

    private void testUpdate() {
        List<Note>noteList = dbHelper.selectAllNotes();
        if (noteList.size() > 0) {
            noteList.get(0).setTitle("Updated Title");
            noteList.get(0).setContent("Updated content");
            dbHelper.update(noteList.get(0));
        }
    }

    private void testDelete() {
        List<Note>noteList = dbHelper.selectAllNotes();
        if (noteList.size() > 0) {
            dbHelper.delete(noteList.get(0));
        }
    }

    private void testInsert() {
        Note note = new Note("Re-watch SQL video", "Rewatch SQLite-videos and do homework", "2016-11-15");
        dbHelper.insert(note);
        Log.d(TAG, "Newly note add");
    }

    private void testSelectAll() {
        List<Note> noteList = dbHelper.selectAllNotes();
        for (Note note : noteList) {
            Log.d(TAG, note.toString());
        }
    }
}
