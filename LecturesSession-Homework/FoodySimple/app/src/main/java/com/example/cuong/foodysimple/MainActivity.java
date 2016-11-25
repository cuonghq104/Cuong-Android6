package com.example.cuong.foodysimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cuong.foodysimple.models.Food;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_food)
    ListView lvFood;

    ArrayList<Food> foodList;

    String url = "https://a-server.herokuapp.com/api/food";

    FoodArrayAdapter foodArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        sendGET();
    }

    private void sendGET() {
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

                Food[] foods = gson.fromJson(body, Food[].class);

                foodList.clear();

                foodList.addAll(Arrays.asList(foods));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        foodArrayAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void setupUI() {
        foodList = new ArrayList<>();
        foodArrayAdapter = new FoodArrayAdapter(
                MainActivity.this,
                R.layout.list_item_food,
                foodList
        );
        lvFood.setAdapter(foodArrayAdapter);
    }
}
