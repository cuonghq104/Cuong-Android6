package hq.cuong.lab4_final_version.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.lab4_final_version.R;
import hq.cuong.lab4_final_version.events.FragmentEvent;
import hq.cuong.lab4_final_version.events.FragmentUrlEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyDetailFragment extends Fragment {


    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_website)
    TextView tvWebsite;

    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @BindView(R.id.iv_company_picture_icon)
    ImageView ivCompanyPicture;

    private String imageUrl;

    private String name;

    private String website;

    private String phone;

    public CompanyDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_detail, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        Bundle bundle = getArguments();

        name = bundle.getString(FragmentEvent.KEY_NAME);

        phone = bundle.getString(FragmentEvent.KEY_PHONE);

        website = bundle.getString(FragmentEvent.KEY_WEBSITE);

        imageUrl = bundle.getString(FragmentEvent.URL);

        tvName.setText(name);

        tvWebsite.setText(Html.fromHtml("<u>" + website + "</u>"));

        tvPhone.setText(String.format("Phone : %s", phone));
    }

    @OnClick(R.id.iv_company_picture_icon)
    public void iconClick() {
        EventBus.getDefault().post(new FragmentUrlEvent(new ImageFragment(), true, imageUrl, name));
    }

    @OnClick(R.id.tv_website)
    public void websiteClick() {
        EventBus.getDefault().post(new FragmentUrlEvent(new WebViewFragment(), true, website, name));
    }

    @OnClick(R.id.tv_phone)
    public void onPhoneClick() {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));

        startActivity(intent);
    }
}
