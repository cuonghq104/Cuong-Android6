package com.example.cuong.simpledictionary;

import android.app.Application;

import com.example.cuong.simpledictionary.managers.DbHelper;

/**
 * Created by Cuong on 11/18/2016.
 */
public class    DictionaryApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        DbHelper.init(this);
    }
}
