package com.example.cuong.foodysimple;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.foodysimple.models.Food;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong on 11/25/2016.
 */
public class FoodViewHolder {

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_detail)
    TextView tvDetail;

    @BindView(R.id.iv_sample)
    ImageView ivSample;

    @BindView(R.id.tv_price)
    TextView tvPrice;

    public FoodViewHolder(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    public void setData(Food food, Context context) {
        tvName.setText(food.getName());

        tvDetail.setText(food.getDetail());

        tvPrice.setText(String.format("%d VND",food.getPrice()));

        Picasso.with(context).load(food.getImage()).into(ivSample);
    }
}
