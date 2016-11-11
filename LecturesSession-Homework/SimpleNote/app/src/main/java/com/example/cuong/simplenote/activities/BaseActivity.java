package com.example.cuong.simplenote.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Cuong on 11/11/2016.
 */
public class BaseActivity extends AppCompatActivity{
    protected void changeFragment(int resID, Fragment detailFragment, boolean addToBackStack) {
        // 3 : Get FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 4 : Start replacing
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();

        // 5 :
        fragmentTransaction.replace(resID, detailFragment);

        // 6 : (Optional)
        if (addToBackStack)
            fragmentTransaction.addToBackStack(null);
        // 7 :
        fragmentTransaction.commit();
    }
}
