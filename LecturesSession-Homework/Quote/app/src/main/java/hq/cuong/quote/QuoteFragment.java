package hq.cuong.quote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.quote.constants.Constants;
import hq.cuong.quote.jsonmodels.QuoteJSONModel;
import hq.cuong.quote.managers.Preferences;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString();

    @BindView(R.id.iv_background)
    ImageView ivBackground;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_greeting)
    TextView tvGreeting;

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quote, container, false);

        ButterKnife.bind(this, view);
        setupUI();

        return view;
    }

    private void setupUI() {
        ImageLoader.getInstance().displayImage(Constants.UNSPLASH_API, ivBackground);

        sendGetJsonModel();
    }

    private void updateQuote(final QuoteJSONModel quoteJSONModel) {

        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                tvGreeting.setText(String.format("Greeting %s, ", Preferences.getInstance().getUsername()));

                tvContent.setText(Html.fromHtml(quoteJSONModel.getContent().replace("\n", "")));

                tvTitle.setText(quoteJSONModel.getTitle());
            }
        });
    }
    private void sendGetJsonModel() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Constants.QUOTE_API)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                        .setTitle("Warning")
                        .setMessage("Can't access API")
                        .show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse");
                String body = response.body().string();

                Log.d(TAG, String.format("Body %s", body));
                Gson gson = new Gson();

                QuoteJSONModel[] model = gson.fromJson(body, QuoteJSONModel[].class);

                updateQuote(model[0]);
            }
        });
    }
}
