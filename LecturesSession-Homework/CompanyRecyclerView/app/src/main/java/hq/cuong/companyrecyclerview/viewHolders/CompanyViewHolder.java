package hq.cuong.companyrecyclerview.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.companyrecyclerview.DetailActivity;
import hq.cuong.companyrecyclerview.MainActivity;
import hq.cuong.companyrecyclerview.R;
import hq.cuong.companyrecyclerview.events.ChangeDetailActivity;
import hq.cuong.companyrecyclerview.models.Company;

/**
 * Created by Cuong on 12/13/2016.
 */
public class CompanyViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = CompanyViewHolder.class.toString();

    @BindView(R.id.iv_company)
    ImageView ivCompany;

    @BindView(R.id.tv_name)
    TextView tvName;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Company company/*, View.OnClickListener onClickListener*/) {

        tvName.setText(company.getName());

        Picasso.with(this.itemView.getContext()).load(company.getImageUrl()).into(ivCompany);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, String.format("Company %s", company.toString()));
                EventBus.getDefault().post(new ChangeDetailActivity(new DetailActivity(), company));
            }
        });
    }
}
