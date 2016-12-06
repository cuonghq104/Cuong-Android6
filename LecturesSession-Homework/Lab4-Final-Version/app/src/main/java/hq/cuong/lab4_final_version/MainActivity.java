package hq.cuong.lab4_final_version;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import hq.cuong.lab4_final_version.events.FragmentEvent;
import hq.cuong.lab4_final_version.events.FragmentUrlEvent;
import hq.cuong.lab4_final_version.fragments.ListViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        changeFragment(new ListViewFragment(), false);
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Subscribe
    public void switchFragment(FragmentEvent fragmentEvent) {

        Bundle bundle = new Bundle();

        bundle.putString(FragmentEvent.KEY_NAME, fragmentEvent.getItem().getName());

        bundle.putString(FragmentEvent.KEY_PHONE, fragmentEvent.getItem().getPhone());

        bundle.putString(FragmentEvent.KEY_WEBSITE, fragmentEvent.getItem().getWebsite());

        bundle.putString(FragmentEvent.URL, fragmentEvent.getItem().getImages()[1].getUrl());

        fragmentEvent.getFragment().setArguments(bundle);

        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

    @Subscribe
    public void switchFragment(FragmentUrlEvent fragmentUrlEvent) {

        Bundle bundle = new Bundle();

        bundle.putString(FragmentEvent.URL, fragmentUrlEvent.getUrl());

        bundle.putString(FragmentEvent.KEY_NAME, fragmentUrlEvent.getName());

        fragmentUrlEvent.getFragment().setArguments(bundle);

        changeFragment(fragmentUrlEvent.getFragment(), fragmentUrlEvent.isAddToBackStack());
    }
}
