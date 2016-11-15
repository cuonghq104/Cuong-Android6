package com.example.cuong.laplession1;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Cuong on 11/15/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private TextView txtvAddToCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_dress);
        getReference();
        addListener();
    }

    private void addListener() {
        txtvAddToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdActivity thirdActivity = new ThirdActivity(SecondActivity.this);
                thirdActivity.show();
            }
        });
    }

    private void getReference() {
        txtvAddToCard = (TextView) findViewById(R.id.tv_add_to_card);
    }


}
