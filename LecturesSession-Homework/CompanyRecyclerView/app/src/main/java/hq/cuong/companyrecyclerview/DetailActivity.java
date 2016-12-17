package hq.cuong.companyrecyclerview;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.companyrecyclerview.models.Company;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.iv_image)
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        Company company = (Company) intent.getSerializableExtra(Company.COMPANY_KEY);

        tvName.setText(company.getName());

        Picasso.with(this).load(company.getImageUrl()).into(ivImage);

    }


}
