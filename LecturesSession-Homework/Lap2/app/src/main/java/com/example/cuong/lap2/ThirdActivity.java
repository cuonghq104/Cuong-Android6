package com.example.cuong.lap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnLongClick;

public class ThirdActivity extends AppCompatActivity {

    @BindView(R.id.lv_new)
    ListView lvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        setupUI();
    }

    private void setupUI() {
        NewArrayAdapter newArrayAdapter = new NewArrayAdapter(this, R.layout.list_item_new, New.getNews());

        lvNews.setAdapter(newArrayAdapter);
    }

    @OnItemClick(R.id.lv_new)
    public void onItemClick() {
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
