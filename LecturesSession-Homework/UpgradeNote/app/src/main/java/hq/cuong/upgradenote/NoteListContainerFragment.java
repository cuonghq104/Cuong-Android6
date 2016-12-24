package hq.cuong.upgradenote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.upgradenote.adapters.NoteSlideAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListContainerFragment extends Fragment {


    @BindView(R.id.vp_container)
    ViewPager vpContainer;

    private PagerAdapter pagerAdapter;

    public NoteListContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_list_container, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        pagerAdapter = new NoteSlideAdapter(getActivity().getSupportFragmentManager());
        vpContainer.setAdapter(pagerAdapter);
    }

}
