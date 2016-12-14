package hq.cuong.lab5.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hq.cuong.lab5.databases.DbContext;
import hq.cuong.lab5.fragments.ListViewFragment;
import hq.cuong.lab5.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbContext.init(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, new ListViewFragment())
                .addToBackStack(null);

        fragmentTransaction.commit();
    }
}
