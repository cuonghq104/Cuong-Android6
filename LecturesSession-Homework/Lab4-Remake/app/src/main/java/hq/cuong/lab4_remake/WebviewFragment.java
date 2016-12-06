package hq.cuong.lab4_remake;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab4_remake.models.Company;
import hq.cuong.lab4_remake.models.Item;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebviewFragment extends Fragment {


    @BindView(R.id.wv_website)
    WebView wvWebsite;

    int position;

    public WebviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        Bundle bundle = new Bundle();
        position = bundle.getInt(MainActivity.CONTACT_ITEM_KEY);

        Item company = ContactFragment.companyArrayList.get(position);
        ButterKnife.bind(this, view);

        wvWebsite.setWebViewClient(new WebViewClient());
        wvWebsite.loadUrl(company.getWebsite());

        return view;
    }

}
