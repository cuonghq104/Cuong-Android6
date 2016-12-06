package hq.cuong.lab4_remake.fragments;

import android.support.v4.app.Fragment;

import hq.cuong.lab4_remake.models.Company;

/**
 * Created by Cuong on 12/4/2016.
 */
public class FragmentEvent {

    Fragment fragment;

    boolean addToBackStack;

    private int company;

    public FragmentEvent(Fragment fragment, boolean addToBackStack, int company) {
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
        this.company = company;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAddToBackStack() {
        return addToBackStack;
    }

    public void setAddToBackStack(boolean addToBackStack) {
        this.addToBackStack = addToBackStack;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }
}
