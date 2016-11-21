package com.example.cuong.lap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mcv_simple)
    MyCompoundView mcvSimple;

    @BindView(R.id.bt_go_to_listView)
    Button btGoToListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_go_to_listView)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
    }
}
