package com.example.cuong.simpledictionary;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.simpledictionary.managers.DbHelper;
import com.example.cuong.simpledictionary.models.Word;

public class DetailScreen extends AppCompatActivity {

    private TextView tvOriginalWord;

    private TextView tvTranslateWord;

    private ImageView imgvFavorite;

    DbHelper dbHelper = DbHelper.instance;

    Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);
        getReference();
        setupUI();
        addListener();
    }

    private void addListener() {
        imgvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word.getIsFavorite() == 1) {
                    word.setIsFavorite(0);
                    imgvFavorite.setImageResource(R.drawable.unfavorite);
                } else {
                    word.setIsFavorite(1);
                    imgvFavorite.setImageResource(R.drawable.favorite);
                }
                dbHelper.updateWord(word);
            }
        });
    }


    private void setupUI() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.POSITION, -1);
        if (position != -1) {
            word = dbHelper.selectWord(position);
            tvOriginalWord.setText(word.getOriginalWord());
            tvTranslateWord.setText(word.getTranslateWord());
            imgvFavorite.setImageResource(word.getIsFavorite() == 0 ? R.drawable.unfavorite : R.drawable.favorite);
        }
    }

    private void getReference() {
        tvOriginalWord = (TextView) findViewById(R.id.tv_original_word);
        tvTranslateWord = (TextView) findViewById(R.id.tv_translate_word);
        imgvFavorite = (ImageView) findViewById(R.id.imgv_favorite);
    }


}
