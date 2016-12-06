package hq.cuong.lab4_remake;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.lab4_remake.fragments.FragmentEvent;
import hq.cuong.lab4_remake.models.Company;
import hq.cuong.lab4_remake.models.Item;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailContactFragment extends Fragment {

    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;

    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @BindView(R.id.tv_website)
    TextView tvWebsite;

    int position;

    public DetailContactFragment() {
        // Required empty public constructor
//        ButterKnife.bind(this.getActivity());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_contact, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();


        position = bundle.getInt(MainActivity.CONTACT_ITEM_KEY);

        Item company = ContactFragment.companyArrayList.get(position);

        tvCompanyName.setText(company.getName());

        tvPhone.setText(company.getPhone());

        tvWebsite.setText(company.getWebsite());

        return view;
    }

    @OnClick(R.id.tv_website)
    public void onWebsiteClick() {
        EventBus.getDefault().post(new FragmentEvent(new WebviewFragment(), true, position));
    }

    @OnClick(R.id.tv_phone)
    public void onPhoneClick() {
        Item company = ContactFragment.companyArrayList.get(position);

        String phone = company.getPhone();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));

        startActivity(intent);
    }
}
