package hq.cuong.lab4_final_version;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.lab4_final_version.models.Image;
import hq.cuong.lab4_final_version.models.Item;

/**
 * Created by Cuong on 12/5/2016.
 */
public class CompanyItemHolder {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;

    @BindView(R.id.tv_name)
    TextView tvName;

    public CompanyItemHolder(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    public void setData(Context context, Item item) {
        tvName.setText(item.getName());

        Picasso.with(context).load(item.getImages()[0].getUrl()).into(ivLogo);
    }
}
