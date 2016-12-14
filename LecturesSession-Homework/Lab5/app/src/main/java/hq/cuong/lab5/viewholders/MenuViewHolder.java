package hq.cuong.lab5.viewholders;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab5.R;
import hq.cuong.lab5.networks.jsonmodels.HomeContent;

/**
 * Created by Cuong on 12/14/2016.
 */
public class MenuViewHolder {
    private static final String TAG = MenuViewHolder.class.toString();

    @BindView(R.id.iv_sample)
    ImageView ivSample;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    public MenuViewHolder(View rootView) {

        ButterKnife.bind(this, rootView);
    }

    public void setData(HomeContent homeContent, Context context) {

        Log.d(TAG, String.format("Data : ", homeContent.toString()));

        tvTitle.setText(homeContent.getName());

        pbLoading.setVisibility(View.VISIBLE);
        Picasso.with(context).load(homeContent.getThumb().getUrl()).into(ivSample, new Callback() {
            @Override
            public void onSuccess() {
                pbLoading.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }
}
