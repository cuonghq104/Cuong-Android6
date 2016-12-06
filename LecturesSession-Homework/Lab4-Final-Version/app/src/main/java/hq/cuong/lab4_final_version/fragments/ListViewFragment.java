package hq.cuong.lab4_final_version.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab4_final_version.R;
import hq.cuong.lab4_final_version.adapters.CompanyArrayAdapter;
import hq.cuong.lab4_final_version.events.FragmentEvent;
import hq.cuong.lab4_final_version.models.Container;
import hq.cuong.lab4_final_version.models.Item;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {


    private static final String TAG = ListViewFragment.class.toString();

    private String url = "https://a-server.herokuapp.com/api/company";

    private ArrayList<Item> items = new ArrayList<>();

    private CompanyArrayAdapter companyArrayAdapter;
    public ListViewFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.lv_item)
    ListView lvItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        sendGet();
        addListener();
        return view;
    }

    private void addListener() {
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventBus.getDefault().post(new FragmentEvent(new CompanyDetailFragment(), true, items.get(position)));
            }
        });
    }

    private void setupUI() {
        companyArrayAdapter = new CompanyArrayAdapter(
                getContext(), R.layout.company_list_item, items
        );

        lvItem.setAdapter(companyArrayAdapter);
    }

    private void sendGet() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.d(TAG, "Response");

                String body = response.body().string();

                Gson gson = new Gson();

                Container container = gson.fromJson(body, Container.class);

                Log.d(TAG, String.format("Container : %s", container.toString()));

                if (items.size() != 0)
                    return;
                for (Item item : container.getContent().getItems()) {
                    Log.d(TAG, item.toString());
                    items.add(item);
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        companyArrayAdapter.notifyDataSetChanged();
                    }
                });

                Log.d(TAG, String.format("Size %d", items.size()));
            }
        });
    }

}
