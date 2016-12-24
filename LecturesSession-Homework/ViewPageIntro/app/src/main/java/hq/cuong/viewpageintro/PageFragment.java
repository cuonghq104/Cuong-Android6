package hq.cuong.viewpageintro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.viewpageintro.models.Coach;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    @BindView(R.id.iv_coach)
    ImageView ivCoach;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_bio)
    TextView tvBio;

    private Coach coach;

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_page, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        tvName.setText(coach.getName());
        tvBio.setText(coach.getBio());
        String imgUrl = coach.getImageUrl();
        int imgRes = getContext().getResources().getIdentifier(imgUrl, "drawable", getContext().getPackageName());
        ivCoach.setImageResource(imgRes);
    }

}
