package hq.cuong.lab4_remake;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab4_remake.fragments.FragmentEvent;
import hq.cuong.lab4_remake.models.BigThing;
import hq.cuong.lab4_remake.models.Company;
import hq.cuong.lab4_remake.models.Item;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    private static final String TAG = ContactFragment.class.toString();

    //    @BindView(R.id.lv_contact)
    ListView lvContact;

    public static ArrayList<Item> companyArrayList = new ArrayList<>();

    public static ArrayList<Item> getCompanyArrayList() {
        return companyArrayList;
    }

    public ContactFragment() {
        companyArrayList = new ArrayList<>();
    }

    private String url = "https://a-server.herokuapp.com/api/company";

    public static void add(Item item) {
        companyArrayList.add(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
//        ButterKnife.bind(this, view);
        lvContact = (ListView) view.findViewById(R.id.lv_contact);

        Toast.makeText(getActivity(), String.format("%d", companyArrayList.size()), Toast.LENGTH_SHORT).show();
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventBus.getDefault().post(new FragmentEvent(new DetailContactFragment(), true , position));
            }
        });

        setupUI();
        return view;
    }

    private void setupUI() {
        sendGet();

        CompanyAdapter companyAdapter = new CompanyAdapter(this.getContext(), R.layout.list_item_contact, companyArrayList);

        lvContact.setAdapter(companyAdapter);

    }

    private void sendGet() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Toast.makeText(getActivity(), "Response", Toast.LENGTH_SHORT).show();

                String body = response.body().string();

                Gson gson = new Gson();

                BigThing bigThing = gson.fromJson(body, BigThing.class);
                for (Item item : bigThing.getContent().getItems()) {
                    companyArrayList.add(item);
                    Log.d(TAG, String.format("Item : %", item.toString()));
                }
            }
        });
    }
}
