package hq.cuong.lab4_final_version.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab4_final_version.R;
import hq.cuong.lab4_final_version.events.FragmentEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {


    @BindView(R.id.wv_homepage)
    WebView wvHomepage;

    private String url;

    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_web_view, container, false);
        ButterKnife.bind(this, view);

        getDataFromBundle();
        wvHomepage.setWebViewClient(new WebViewClient());
        wvHomepage.loadUrl(url);

        return view;
    }

    private void getDataFromBundle() {
        Bundle bundle = getArguments();

        url = bundle.getString(FragmentEvent.URL);
    }


}
