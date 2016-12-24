package hq.cuong.viewpageintro.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hq.cuong.viewpageintro.PageFragment;
import hq.cuong.viewpageintro.models.Coach;

/**
 * Created by Cuong on 12/23/2016.
 */
public class PageChangeAdapter extends FragmentStatePagerAdapter {

    private static final int NUMBER_PAGES = 4;

    public PageChangeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        PageFragment pageFragment = new PageFragment();
        pageFragment.setCoach(Coach.getCOACHES()[position]);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return NUMBER_PAGES;
    }
}
