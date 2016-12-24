package hq.cuong.upgradenote.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.adapters.NoteAdapter;
import hq.cuong.upgradenote.events.ChangeFragmentEvent;
import hq.cuong.upgradenote.managers.Preferences;
import hq.cuong.upgradenote.networks.jsonmodels.LabNote;
import hq.cuong.upgradenote.networks.services.ToDoListService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    private static final String TAG = NoteListFragment.class.toString();

    @BindView(R.id.rv_note_list)
    RecyclerView rvNoteList;

    @BindView(R.id.bt_add_note)
    FloatingActionButton btAddNote;

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

        getAllNote();

        setupUI();

        return view;
    }

    private void setupUI() {
        noteAdapter = new NoteAdapter();
        rvNoteList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvNoteList.setAdapter(noteAdapter);
    }

    private void getAllNote() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://a-server.herokuapp.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ToDoListService toDoListService = retrofit.create(ToDoListService.class);

        Call<ArrayList<LabNote>> call = toDoListService.getList(Preferences.getInstance().getToken());

        call.enqueue(new Callback<ArrayList<LabNote>>() {
            @Override
            public void onResponse(Call<ArrayList<LabNote>> call, Response<ArrayList<LabNote>> response) {
                ArrayList<LabNote> labNotes = response.body();

                LabNote.setLabNotes(labNotes);

                setupUI();
            }

            @Override
            public void onFailure(Call<ArrayList<LabNote>> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.bt_add_note)
    public void addNewNote() {
        EventBus.getDefault().post(new ChangeFragmentEvent(new NewNoteFragment(), true));
    }
}
