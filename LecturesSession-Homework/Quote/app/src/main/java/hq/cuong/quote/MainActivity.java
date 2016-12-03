package hq.cuong.quote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import hq.cuong.quote.events.FragmentEvent;
import hq.cuong.quote.managers.Preferences;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        changeFragment();
    }

    private void changeFragment() {
        if (Preferences.getInstance().getUsername() == null) {
            changeFragment(new RegisterFragment(), false);
        } else {
            changeFragment(new QuoteFragment(), false);
        }
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent) {
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);

        if (addToBackStack)
            fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
}
