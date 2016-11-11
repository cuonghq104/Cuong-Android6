package com.example.cuong.simplenote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.cuong.simplenote.OnNoteUpdateListener;
import com.example.cuong.simplenote.fragments.DetailFragment;
import com.example.cuong.simplenote.models.Note;
import com.example.cuong.simplenote.R;

import java.util.Vector;

public class MainActivity extends BaseActivity implements OnNoteUpdateListener{

    public static final String POSITION = "position";
    Button btnAdd;
    ListView lvNote;

    private static ArrayAdapter<Note> noteArrayAdapter;

    private static Vector<Note> noteVector = Note.noteVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReference();
        setupUI();
        addListener();
    }

    public static void addNewNote(Note note) {
        noteVector.add(note);
    }

    public static void updateNote(int position, Note note) {
        noteVector.set(position, note);
    }

    public static void notifyDataSetChanged() {
        noteArrayAdapter.notifyDataSetChanged();
    }

    public static Note getNote(int i) {
        return noteVector.get(i);
    }

    private void setupUI() {
        noteVector = new Vector<>();
        noteArrayAdapter = new ArrayAdapter<Note>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                noteVector
        );
        btnAdd.setText("Add new note");
        lvNote.setAdapter(noteArrayAdapter);
    }

    private void addListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.fl_detail) == null) {

                    Intent intent = new Intent(MainActivity.this, NoteDetail.class);
                    intent.putExtra(Note.OPERATION_KEY, Note.OP_ADD);
                    startActivity(intent);
                } else {
                    DetailFragment detailFragment = DetailFragment.create(new Note(""), Note.OP_ADD);
                    detailFragment.setOnNoteUpdateListener(MainActivity.this);
                    changeFragment(R.id.fl_detail, detailFragment, true);
                }
            }
        });

        lvNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (findViewById(R.id.fl_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, NoteDetail.class);
                    intent.putExtra(Note.OPERATION_KEY, Note.OP_UPDATE);
                    intent.putExtra(POSITION, position);
                    startActivity(intent);
                } else {
                    DetailFragment detailFragment = DetailFragment.create(noteVector.get(position), Note.OP_UPDATE);
                    detailFragment.setOnNoteUpdateListener(MainActivity.this);
                    changeFragment(R.id.fl_detail, detailFragment, true);
                }
            }
        });

        lvNote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                noteVector.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });
    }

    private void getReference() {
        btnAdd = (Button) findViewById(R.id.btn_add);
        lvNote = (ListView) findViewById(R.id.lv_note);
    }

    @Override
    public void onUpdate() {
//        finish();
    }
}
