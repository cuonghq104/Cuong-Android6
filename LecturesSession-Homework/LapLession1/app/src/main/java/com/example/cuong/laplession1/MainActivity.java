package com.example.cuong.laplession1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgvWomanFashion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_store);
        getReference();
        addListener();
    }

    private void addListener() {
        imgvWomanFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        SecondActivity.class
                );
                startActivity(intent);
            }
        });
    }

    private void getReference() {
        imgvWomanFashion = (ImageView) findViewById(R.id.imgv_women_fashion);
    }
}
