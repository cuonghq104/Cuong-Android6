package com.example.cuong.loginactivityintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cuong.loginactivityintro.models.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.et_userName)
    EditText etUsername;

    @BindView(R.id.bt_login)
    Button btLogin;

    private String url = "https://a5-tumblelog.herokuapp.com/api/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_login)
    public void onClick() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        User user = new User(username, password);
        final Gson gson = new Gson();

        String data = gson.toJson(user);
        final RequestBody requestBody = RequestBody.create(JSON, data);

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


                try {
                    JSONObject jsonObject = new JSONObject(body);
                    int code = jsonObject.getInt("code");
                    String message;
                    if (code == 0) {
                        message = getResources().getString(R.string.login_failed);
                    } else {
                        message = getResources().getString(R.string.login_passed);
                    }
                    final String finalMessage = message;

                    Log.d(TAG, String.format("SSSSS %s", message));
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, finalMessage, Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

}
