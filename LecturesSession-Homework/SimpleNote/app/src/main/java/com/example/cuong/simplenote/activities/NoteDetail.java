package com.example.cuong.simplenote.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.cuong.simplenote.OnNoteUpdateListener;
import com.example.cuong.simplenote.fragments.DetailFragment;
import com.example.cuong.simplenote.models.Note;
import com.example.cuong.simplenote.R;

public class NoteDetail extends BaseActivity implements OnNoteUpdateListener{


//    int operation;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
//        getReference();
//        setUpUI();
//        addListener();
        Intent intent = getIntent();
        int operation = intent.getIntExtra(Note.OPERATION_KEY, -1);
        if (operation == Note.OP_UPDATE) {
            int position = intent.getIntExtra(MainActivity.POSITION, -1);
            if (position != -1) {
                Note note = MainActivity.getNote(position);
                DetailFragment detailFragment = DetailFragment.create(note, operation);

                changeFragment(R.id.fl_detail, detailFragment, false);

            }
        } else {
            DetailFragment detailFragment = DetailFragment.create(new Note(""), operation);

            changeFragment(R.id.fl_detail, detailFragment, false);
        }
    }

    @Override
    public void onUpdate() {
        finish();
    }


//    private void getReference() {
//        etNote = (EditText) findViewById(R.id.et_note);
//        btnSave = (Button) findViewById(R.id.btn_save);
//    }

//    private void setUpUI() {
//        etNote.setHint("<Text here>");
//        Intent intent = getIntent();
//        operation = intent.getIntExtra(Note.OPERATION_KEY, -1);
//        if (operation == Note.OP_UPDATE) {
//            btnSave.setText("UPDATE");
//            position = intent.getIntExtra(MainActivity.POSITION, -1);
//            if (position != -1) {
//                Note note = MainActivity.getNote(position);
//                etNote.setText(note.getContent());
//            }
//        } else {
//            btnSave.setText("CREATE");
//            etNote.setText("");
//        }
//
//    }

//    private void addListener() {
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (operation == Note.OP_UPDATE) {
//                    Note note = new Note(etNote.getText().toString());
//                    MainActivity.updateNote(position, note);
//                    MainActivity.notifyDataSetChanged();
//                    finish();
//                }
//                else {
//                    if (!etNote.getText().toString().matches("")) {
//                        MainActivity.addNewNote(new Note(etNote.getText().toString()));
//                        MainActivity.notifyDataSetChanged();
//                        finish();
//                    }
//                }
//            }
//        });
//    }


}
