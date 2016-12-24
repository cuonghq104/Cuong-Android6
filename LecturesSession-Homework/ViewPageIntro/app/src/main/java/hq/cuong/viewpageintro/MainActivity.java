package hq.cuong.viewpageintro;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.viewpageintro.adapters.PageChangeAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp_intro)
    ViewPager vpIntro;

    private PagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        pageAdapter = new PageChangeAdapter(getSupportFragmentManager());

        vpIntro.setAdapter(pageAdapter);
    }

    @Override
    public void onBackPressed() {
        if (vpIntro.getCurrentItem() == 0) {
            super.onBackPressed();
        }
        else {
            vpIntro.setCurrentItem(vpIntro.getCurrentItem() - 1);
        }
    }
}
