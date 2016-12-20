package hq.cuong.upgradenote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.events.ChangeFragmentEvent;
import hq.cuong.upgradenote.managers.Preferences;
import hq.cuong.upgradenote.networks.jsonmodels.LoginResponseBody;
import hq.cuong.upgradenote.networks.jsonmodels.RegisterResponseBody;
import hq.cuong.upgradenote.networks.jsonmodels.UserAccount;
import hq.cuong.upgradenote.networks.services.LoginService;
import hq.cuong.upgradenote.networks.services.RegisterService;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginAndRegisterFragment extends Fragment {


    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.bt_login)
    Button btLogin;

    @BindView(R.id.bt_register)
    Button btRegister;

    private RegisterResponseBody registerResponseBody;

    private LoginResponseBody loginResponseBody;

    public LoginAndRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_and_register, container, false);
        ButterKnife.bind(this, view);



        return view;
    }

    @OnClick(R.id.bt_register)
    public void onRegisterClick() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://a-server.herokuapp.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterService registerService = retrofit.create(RegisterService.class);

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        UserAccount userAccount = new UserAccount(username, password);

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson().toJson(userAccount))
        );

        Call<RegisterResponseBody> register = registerService.register(requestBody);

        register.enqueue(new Callback<RegisterResponseBody>() {
            @Override
            public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
                if (response.code() != 200) {
                    Toast.makeText(getContext(), R.string.user_already_exists, Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    registerResponseBody = response.body();
                    Toast.makeText(getContext(), registerResponseBody.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponseBody> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.bt_login)
    public void onLoginClick() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://a-server.herokuapp.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginService loginService = retrofit.create(LoginService.class);

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        UserAccount userAccount = new UserAccount(username, password);

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson().toJson(userAccount))
        );

        Call<LoginResponseBody> login = loginService.login(requestBody);

        login.enqueue(new Callback<LoginResponseBody>() {
            @Override
            public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                loginResponseBody = response.body();
                Toast.makeText(getContext(), loginResponseBody.getMessage(), Toast.LENGTH_SHORT).show();
                Preferences.getInstance().putToken(loginResponseBody.getToken());
                EventBus.getDefault().post(new ChangeFragmentEvent(new NoteListFragment(), true));
            }

            @Override
            public void onFailure(Call<LoginResponseBody> call, Throwable t) {

            }
        });
    }
}
