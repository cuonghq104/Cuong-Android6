package hq.cuong.companyrecyclerview.events;

import android.app.Activity;

import hq.cuong.companyrecyclerview.models.Company;

/**
 * Created by Cuong on 12/13/2016.
 */
public class ChangeDetailActivity {

    Activity activity;

    Company company;

    public ChangeDetailActivity(Activity activity, Company company) {
        this.activity = activity;
        this.company = company;
    }

    public Activity getActivity() {
        return activity;
    }

    public Company getCompany() {
        return company;
    }
}
