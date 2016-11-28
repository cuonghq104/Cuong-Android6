package com.example.cuong.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.cuong.lab3.models.Customer;
import com.example.cuong.lab3.models.CustomerAccountHolder;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = SignUpActivity.class.toString();
    @BindView(R.id.et_customer_id)
    EditText etCustomerId;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.et_date_of_birth)
    EditText etDateOfBirth;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_month_of_birth)
    EditText etMonthOfBirth;

    @BindView(R.id.et_phone_number)
    EditText etPhone;

    @BindView(R.id.et_year_of_birth)
    EditText etYearOfBirth;

    @BindView(R.id.bt_sign_in)
    Button btSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_sign_in)
    public void onClick() {
        String url = "https://a-server.herokuapp.com/api/register";

        String email = etEmail.getText().toString();

        String customerId = etCustomerId.getText().toString();

        String password = etPassword.getText().toString();

        String phone = etPhone.getText().toString();

        int dayOfBirth = Integer.parseInt(etDateOfBirth.getText().toString());

        int monthOfBirth = Integer.parseInt(etMonthOfBirth.getText().toString());

        int yearOfBirth = Integer.parseInt(etYearOfBirth.getText().toString());


        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        Customer customer = new Customer(phone, customerId, email, password, dayOfBirth, monthOfBirth, yearOfBirth);

        final Gson gson = new Gson();

        String data = gson.toJson(customer);
        RequestBody requestBody = RequestBody.create(JSON, data);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();

                CustomerAccountHolder customerAccountHolder = gson.fromJson(body, CustomerAccountHolder.class);

                Log.d(TAG, String.format("%s", customerAccountHolder.toString()));
            }
        });
    }
}
