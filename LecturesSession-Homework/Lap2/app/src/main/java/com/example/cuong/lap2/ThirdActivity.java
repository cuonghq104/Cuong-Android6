package com.example.cuong.lap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
}
