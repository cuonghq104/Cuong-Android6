package hq.cuong.upgradenote.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import hq.cuong.upgradenote.events.ChangeFragmentEvent;
import hq.cuong.upgradenote.fragments.LoginAndRegisterFragment;
import hq.cuong.upgradenote.fragments.NewNoteFragment;
import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.fragments.NoteListFragment;
import hq.cuong.upgradenote.managers.Preferences;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        if (Preferences.getInstance().getToken() == null) {
            changeFragment(new LoginAndRegisterFragment(), false);
        } else {
            changeFragment(new NoteListFragment(), false);
        }
    }

    public void changeFragment(Fragment fragment, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction().
                replace(R.id.fl_container, fragment);

        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    @Subscribe
    public void showNoteList(ChangeFragmentEvent changeFragmentEvent) {

        changeFragment(changeFragmentEvent.getFragment(), changeFragmentEvent.isAddToBackStack());

    }
}
