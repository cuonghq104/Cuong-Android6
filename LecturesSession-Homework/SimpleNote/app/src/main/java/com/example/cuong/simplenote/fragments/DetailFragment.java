package com.example.cuong.simplenote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cuong.simplenote.OnNoteUpdateListener;
import com.example.cuong.simplenote.R;
import com.example.cuong.simplenote.activities.MainActivity;
import com.example.cuong.simplenote.models.Note;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private EditText etNote;

    private Button btnSave;

    private Note note;

    private int operation;

    public DetailFragment() {
        // Required empty public constructor
    }

    private OnNoteUpdateListener onNoteUpdateListener;

    public void setOnNoteUpdateListener(OnNoteUpdateListener onNoteUpdateListener) {
        this.onNoteUpdateListener = onNoteUpdateListener;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        getReference(view);
        setUpUI();
        addListener();
        return view;
    }

    private void getReference(View view) {
        etNote = (EditText) view.findViewById(R.id.et_note);
        btnSave = (Button) view.findViewById(R.id.btn_save);
    }

    private void addListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation == Note.OP_UPDATE) {
//                    Note note = new Note(etNote.getText().toString());
//                    MainActivity.updateNote(position, note);
                    note.setContent(etNote.getText().toString());
                    MainActivity.notifyDataSetChanged();
                    if (onNoteUpdateListener != null) {
                        onNoteUpdateListener.onUpdate();
                    }
                }
                else {
                    if (!etNote.getText().toString().matches("")) {
                        MainActivity.addNewNote(new Note(etNote.getText().toString()));
                        MainActivity.notifyDataSetChanged();
                        if (onNoteUpdateListener != null) {
                            onNoteUpdateListener.onUpdate();
                        }
                    }
                }
            }
        });
    }

    private void setUpUI() {
        if (operation == Note.OP_UPDATE) {
            btnSave.setText("UPDATE");
            etNote.setText(note.getContent());
        } else {
            btnSave.setText("CREATE");
            etNote.setHint("<Text here>");
            etNote.setText("");
        }

    }

    public static DetailFragment create(Note note, int operation) {
        DetailFragment detailFragment = new DetailFragment();

        detailFragment.setOperation(operation);
        detailFragment.setNote(note);

        return detailFragment;
    }

}
