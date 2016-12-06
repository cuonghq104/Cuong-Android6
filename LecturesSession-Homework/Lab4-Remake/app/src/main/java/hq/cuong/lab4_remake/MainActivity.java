package hq.cuong.lab4_remake;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import hq.cuong.lab4_remake.fragments.FragmentEvent;
import hq.cuong.lab4_remake.models.BigThing;
import hq.cuong.lab4_remake.models.Company;
import hq.cuong.lab4_remake.models.Item;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    public static final String CONTACT_ITEM_KEY = "item";

    private static final String TAG = MainActivity.class.toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(new ContactFragment(), false);
        EventBus.getDefault().register(this);
    }



    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction().replace(R.id.fl_container, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent) {

        Bundle bundle = new Bundle();

        bundle.putInt(CONTACT_ITEM_KEY, fragmentEvent.getCompany());

        fragmentEvent.getFragment().setArguments(bundle);
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }
}
