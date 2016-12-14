package hq.cuong.lab5.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab5.R;
import hq.cuong.lab5.adapters.MenuAdapter;
import hq.cuong.lab5.databases.DbContext;
import hq.cuong.lab5.networks.jsonmodels.HomeContent;
import hq.cuong.lab5.networks.jsonmodels.HomeContentContainer;
import hq.cuong.lab5.networks.jsonmodels.HomeRequestBody;
import hq.cuong.lab5.networks.services.HomeService;
import io.realm.RealmList;
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
public class ListViewFragment extends Fragment {


    @BindView(R.id.lv_menu)
    ListView lvMenu;

    private static final String TAG = ListViewFragment.class.toString();

    private List<HomeContent> list;

    private MenuAdapter menuAdapter;

    public ListViewFragment() {
        // Required empty public constructor
    }

    private HomeContentContainer homeContentContainer = new HomeContentContainer();

    //    private RealmList<HomeContent> realmList = new RealmList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        ButterKnife.bind(this, view);

        getData();

        return view;
    }

    private void setupUI() {

        menuAdapter = new MenuAdapter(getContext(), R.layout.menu_item, list);

        lvMenu.setAdapter(menuAdapter);

    }

    private void getData() {
        list = new RealmList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.30shine.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HomeService homeService = retrofit.create(HomeService.class);

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson().toJson(new HomeRequestBody()))
        );

        Call<HomeContentContainer> call = homeService.container(requestBody);

        call.enqueue(new Callback<HomeContentContainer>() {
            @Override
            public void onResponse(Call<HomeContentContainer> call, Response<HomeContentContainer> response) {
                Log.d(TAG, "OnResponse");
                homeContentContainer = response.body();
                list = homeContentContainer.getHomeContent();
                for (HomeContent homeContent : homeContentContainer.getHomeContent()) {
                    Log.d(TAG, String.format("Home Content %s", homeContent.toString()));
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list = homeContentContainer.getHomeContent();
                        setupUI();
                    }
                });

                DbContext.getInstance().clearRealm();
                DbContext.getInstance().insert(homeContentContainer);
                Log.d(TAG, String.format("Size : %d", DbContext.getInstance().getSize()));
            }

            @Override
            public void onFailure(Call<HomeContentContainer> call, Throwable t) {
                Log.d(TAG, "No Internet");

                homeContentContainer = DbContext.getInstance().allContent();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list = homeContentContainer.getHomeContent();
                        setupUI();
                    }
                });

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, String.format("Realm list size : %d", list.size()));
                    }
                });
                for (HomeContent homeContent : homeContentContainer.getHomeContent()) {
                    Log.d(TAG, String.format("Home Content %s", homeContent.toString()));
                }
                Log.d(TAG, String.format("Size : %d", DbContext.getInstance().getSize()));

            }
        });

        Log.d(TAG, String.format("read list size %d", list.size()));

    }


}
