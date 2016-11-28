package com.example.cuong.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cuong.lab3.models.HairCatalogue;
import com.example.cuong.lab3.models.HairStyle;
import com.example.cuong.lab3.models.SalonGroup;
import com.example.cuong.lab3.models.Something;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private ArrayList<Something> somethingList = new ArrayList<>();

    private HairStyleArrayAdapter hairStyleArrayAdapter;

    private ArrayList<HairStyle> hairStyles;

    private ArrayList<SalonGroup> salonGroupsList = new ArrayList<>();
    @BindView(R.id.lv_hair_styles)
    ListView lvHairStyle;

    @BindView(R.id.tv_change_screen)
    TextView tvChangeScreen;

    TextView tvTitle;

    @OnClick(R.id.tv_change_screen)
    public void onClick() {
        Intent intent = new Intent(
                MainActivity.this,
                SignUpActivity.class
        );
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupUI();
        sendGet();
        sendGetHairSalon();
        sendGetHS();
    }

    private void setupUI() {
        hairStyles = new ArrayList<>();

        hairStyleArrayAdapter = new HairStyleArrayAdapter(
                MainActivity.this,
                R.layout.hair_style_item,
                hairStyles
        );

        lvHairStyle.setAdapter(hairStyleArrayAdapter);
    }

    private void sendGetHS() {
        String url = "http://a-server.herokuapp.com/api/hairstyle";

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
                String body = response.body().string();

                Gson gson = new Gson();

                final HairCatalogue hairCatalogue = gson.fromJson(body, HairCatalogue.class);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (HairStyle hairStyle : hairCatalogue.getHairStyles()) {
                            hairStyles.add(hairStyle);
                        }
                        hairStyleArrayAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void sendGetHairSalon() {
        String url = "http://a-server.herokuapp.com/api/salon";

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
                String body = response.body().string();

                Gson gson = new Gson();

                final SalonGroup salonGroups = gson.fromJson(body, SalonGroup.class);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(salonGroups.toString());
                    }
                });
            }
        });
    }

    private void sendGet() {
        String url = "https://jsonplaceholder.typicode.com/posts";

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
                String body = response.body().string();

                Gson gson = new Gson();

                Something[] somethings = gson.fromJson(body, Something[].class);

                somethingList.clear();

                somethingList.addAll(Arrays.asList(somethings));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (Something something : somethingList) {
                            Log.d(TAG, something.toString());
                        }
                    }
                });
            }
        });
    }
}
