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

}
