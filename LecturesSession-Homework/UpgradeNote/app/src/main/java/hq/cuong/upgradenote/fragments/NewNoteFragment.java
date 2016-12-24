package hq.cuong.upgradenote.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.upgradenote.NoteListContainerFragment;
import hq.cuong.upgradenote.R;
//import hq.cuong.upgradenote.databases.DbContext;
import hq.cuong.upgradenote.events.ChangeFragmentEvent;
import hq.cuong.upgradenote.managers.Preferences;
import hq.cuong.upgradenote.models.NoteColor;
import hq.cuong.upgradenote.networks.jsonmodels.LabNote;
import hq.cuong.upgradenote.networks.jsonmodels.NewNoteRequestBody;
import hq.cuong.upgradenote.networks.services.NewNoteService;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewNoteFragment extends Fragment {

    @BindView(R.id.bt_color)
    Button btColor;

    @BindView(R.id.et_title)
    EditText etTitle;

    @BindView(R.id.et_content)
    EditText etContent;

    @BindView(R.id.bt_save)
    FloatingActionButton btSave;

    @BindView(R.id.cv_container)
    CardView cvContainer;

    private String color;

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

        return view;
    }

    @OnClick(R.id.bt_color)
    public void pickColor() {
        ColorPickerDialogBuilder
                .with(getContext())
                .setTitle("Choose Color")
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int i) {
                        color = Integer.toHexString(i);
                        Toast.makeText(getContext(), color, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, Integer[] integers) {
                        btColor.setBackgroundColor(i);
                        cvContainer.setBackgroundColor(i);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();
    }

    @OnClick(R.id.bt_save)
    public void addNewNote() {
        String title = etTitle.getText().toString();
        String content = etContent.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://a-server.herokuapp.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewNoteService newNoteService = retrofit.create(NewNoteService.class);

        NewNoteRequestBody newNoteRequestBody = new NewNoteRequestBody(title, content, String.format("#%s", color), false);

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson().toJson(newNoteRequestBody))
        );

        Call<ArrayList<LabNote>> call = newNoteService.getList(Preferences.getInstance().getToken(), requestBody);

        call.enqueue(new Callback<ArrayList<LabNote>>() {
            @Override
            public void onResponse(Call<ArrayList<LabNote>> call, Response<ArrayList<LabNote>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<LabNote>> call, Throwable t) {

            }
        });
        EventBus.getDefault().post(new ChangeFragmentEvent(new NoteListContainerFragment(), false));
    }

}
