package hq.cuong.lab4_final_version.events;

import android.support.v4.app.Fragment;

import hq.cuong.lab4_final_version.models.Item;

/**
 * Created by Cuong on 12/5/2016.
 */
public class FragmentEvent {

    public static final String KEY_NAME = "name";

    public static final String KEY_WEBSITE = "website";

    public static final String KEY_PHONE = "phone";

    public static final String URL = "imageUrl";

    public Item getItem() {
        return item;
    }

    private Fragment fragment;

    private boolean addToBackStack;

    private Item item;

    public FragmentEvent(Fragment fragment, boolean addToBackStack, Item item) {
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
        this.item = item;
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

}
