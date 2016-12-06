package hq.cuong.lab4_remake;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.lab4_remake.models.Company;
import hq.cuong.lab4_remake.models.Item;

/**
 * Created by Cuong on 12/4/2016.
 */
public class ContactViewHolder {

    private static final String TAG = ContactViewHolder.class.toString();
    
    //    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;

//    @BindView(R.id.tv_phone)
    TextView tvPhone;

//    @BindView(R.id.tv_website)
    TextView tvWebsite;

    public ContactViewHolder(View rootView) {
        addReference(rootView);
//        ButterKnife.bind(this, rootView);
    }

    private void addReference(View view) {
        tvCompanyName = (TextView) view.findViewById(R.id.tv_company_name);
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        tvWebsite = (TextView) view.findViewById(R.id.tv_website);
    }

    public void setData(Item company) {
        tvCompanyName.setText(company.getName());

        tvPhone.setText(company.getPhone());

        tvWebsite.setText(company.getWebsite());
    }

    @OnClick(R.id.tv_phone)
    public void onPhoneClick() {
        Log.d(TAG, "onPhoneClick");
    }
}
