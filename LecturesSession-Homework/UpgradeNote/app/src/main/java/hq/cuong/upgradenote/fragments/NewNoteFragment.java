package hq.cuong.upgradenote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.databases.DbContext;
import hq.cuong.upgradenote.events.ChangeFragmentEvent;
import hq.cuong.upgradenote.models.Note;
import hq.cuong.upgradenote.models.NoteColor;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewNoteFragment extends Fragment {

    @BindView(R.id.sp_color)
    Spinner spColor;

    @BindView(R.id.et_title)
    EditText etTitle;

    @BindView(R.id.et_content)
    EditText etContent;

    @BindView(R.id.bt_save)
    Button btSave;

    private ArrayAdapter<String> colorAdapter;

    public NewNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_note, container, false);
        ButterKnife.bind(this, view);
        colorAdapter = new ArrayAdapter(this.getContext(), R.layout.support_simple_spinner_dropdown_item, NoteColor.getNoteColors());
        spColor.setAdapter(colorAdapter);

        return view;
    }

    @OnClick(R.id.bt_save)
    public void addNewNote() {
        String title = etTitle.getText().toString();
        String content = etContent.getText().toString();
        int color = spColor.getSelectedItemPosition();

        Note note = Note.createNote(title, content, color);

        Note.add(note);
        DbContext.getInstance().insert(note);
        EventBus.getDefault().post(new ChangeFragmentEvent(new NoteListFragment(), false));
    }
}
