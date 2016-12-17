package hq.cuong.companyrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.companyrecyclerview.adapters.CompanyAdapter;
import hq.cuong.companyrecyclerview.events.ChangeDetailActivity;
import hq.cuong.companyrecyclerview.models.Company;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_company)
    RecyclerView rvCompany;

    private CompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        setupUI();


    }

    private void setupUI() {
        adapter = new CompanyAdapter();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int mod = position % 3;

                if(position == 0)
                    return 2;
                else if(position < 3)
                    return 1;
                else if(mod == 0)
                    return 2;
                else
                    return 1;
            }
        });

        rvCompany.setLayoutManager(layoutManager);

//        rvCompany.setLayoutManager(new GridLayoutManager(this, 2));

        rvCompany.setAdapter(adapter);

    }

    @Subscribe
    public void changeActivity(ChangeDetailActivity changeDetailActivity) {

        Intent intent = new Intent(
                MainActivity.this,
                changeDetailActivity.getActivity().getClass()
        );
        intent.putExtra(Company.COMPANY_KEY, changeDetailActivity.getCompany());

        startActivity(intent);
    }
}
