package hq.cuong.lab4_final_version.events;

import android.support.v4.app.Fragment;

/**
 * Created by Cuong on 12/5/2016.
 */
public class FragmentUrlEvent {

    private Fragment fragment;

    private boolean addToBackStack;

    private String url;

    private String name;

    public FragmentUrlEvent(Fragment fragment, boolean addToBackStack, String url, String name) {
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
