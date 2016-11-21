package com.example.cuong.lap2;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong on 11/20/2016.
 */
public class NewViewHolder {

    @BindView(R.id.iv_new_image)
    ImageView ivNewImage;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_time_posted)
    TextView tvTimePost;

    public NewViewHolder(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    public void setData(New instance) {
        ivNewImage.setImageResource(instance.getImageResID());

        tvContent.setText(instance.getContent());

        tvTimePost.setText(String.format("%dmin",instance.getTimePosted()));
    }
}
