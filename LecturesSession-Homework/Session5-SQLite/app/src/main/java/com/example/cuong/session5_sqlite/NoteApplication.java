package com.example.cuong.session5_sqlite;

import android.app.Application;
import android.util.Log;

import com.example.cuong.session5_sqlite.managers.DbHelper;

/**
 * Created by Cuong on 11/15/2016.
 */
public class NoteApplication extends Application {

    private static final String TAG = NoteApplication.class.toString();

    @Override
    public void onCreate() {
        Log.d(TAG,"OnCreate");
        super.onCreate();
        DbHelper.init(this);
    }
}
