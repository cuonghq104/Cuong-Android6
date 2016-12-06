package hq.cuong.lab4_final_version.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab4_final_version.R;
import hq.cuong.lab4_final_version.events.FragmentEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {

    @BindView(R.id.iv_company_picture)
    ImageView ivCompanyPicture;

    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;

    private String url;

    private String name;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ButterKnife.bind(this, view);
        setupData();
        setupUI();
        return view;
    }

    private void setupData() {
        Bundle bundle = getArguments();

        name = bundle.getString(FragmentEvent.KEY_NAME);

        url = bundle.getString(FragmentEvent.URL);
    }

    private void setupUI() {
        tvCompanyName.setText(name);

        Picasso.with(getContext()).load(url).into(ivCompanyPicture);
    }

}
