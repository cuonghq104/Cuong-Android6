package com.example.cuong.lab3;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.lab3.models.HairStyle;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong on 11/27/2016.
 */
public class HairStyleItemHolder {

    @BindView(R.id.iv_sample)
    ImageView ivSample;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_detail)
    TextView tvDetail;

    public HairStyleItemHolder(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    public void setData(HairStyle hairStyle, Context context) {
        tvTitle.setText(hairStyle.getTitle());

        tvDetail.setText(hairStyle.getDescription());

        Picasso.with(context).load(hairStyle.getImages().getUrl()).into(ivSample);
    }
}
