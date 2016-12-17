package hq.cuong.upgradenote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.adapters.NoteAdapter;
import hq.cuong.upgradenote.events.ChangeFragmentEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    @BindView(R.id.rv_note_list)
    RecyclerView rvNoteList;

    @BindView(R.id.bt_add_note)
    Button btAddNote;

    private NoteAdapter noteAdapter;

    public NoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        ButterKnife.bind(this, view);
        noteAdapter = new NoteAdapter();
        rvNoteList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvNoteList.setAdapter(noteAdapter);
        return view;
    }

    @OnClick(R.id.bt_add_note)
    public void addNewNote() {
        EventBus.getDefault().post(new ChangeFragmentEvent(new NewNoteFragment(), true));
    }
}
