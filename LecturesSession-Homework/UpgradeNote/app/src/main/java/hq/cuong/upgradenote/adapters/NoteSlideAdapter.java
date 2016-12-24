package hq.cuong.upgradenote.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hq.cuong.upgradenote.SimpleFragment;
import hq.cuong.upgradenote.fragments.NoteListFragment;

/**
 * Created by Cuong on 12/24/2016.
 */
public class NoteSlideAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_PAGES = 2;

    public NoteSlideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NoteListFragment();
            default:
                return new SimpleFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
