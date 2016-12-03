package hq.cuong.quote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.quote.events.FragmentEvent;
import hq.cuong.quote.managers.Preferences;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment{

    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.bt_continue)
    Button btContinue;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.bt_continue)
    public void register() {

        String username = etUsername.getText().toString();

        Preferences.getInstance().putUsername(username);

        EventBus.getDefault().post(new FragmentEvent(new QuoteFragment(), false));
    }
}
