package hq.cuong.retrofitintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import hq.cuong.retrofitintro.networks.DbContext;
import hq.cuong.retrofitintro.networks.jsonmodels.RegisterRequestBody;
import hq.cuong.retrofitintro.networks.jsonmodels.RegisterResponseBody;
import hq.cuong.retrofitintro.networks.jsonmodels.Repo;
import hq.cuong.retrofitintro.networks.services.GithubService;
import hq.cuong.retrofitintro.networks.services.RegisterService;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbContext.getGithubRepository("cuonghq104").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
//        // 1 Create a retrofit
//
//        Retrofit retrofit = new Retrofit.Builder()
//        .baseUrl("http://api.github.com")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build();
//
//        // 2.Create a service
//
//        GithubService githubService = retrofit.create(GithubService.class);
//
//        // 3. Create call
//
//        Call<List<Repo>> call = githubService.listRepos("cuonghq104");
//
//        // 4.Send request
//
//
//        call.enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                Log.d(TAG, "onResponse");
//                List<Repo> repoList = response.body();
//                for (Repo repo : repoList) {
//                    Log.d(TAG, repo.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://a-server.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterService registerService = retrofit.create(RegisterService.class);

        RegisterRequestBody registerRequestBody = new RegisterRequestBody(
                        "xxxx",
                        "xxxx",
                        "email@email.com",
                        "xxxx",
                        12,
                        12,
                        1992
        );

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson().toJson(registerRequestBody))
        );

        Call<RegisterResponseBody> register = registerService.register(requestBody);

        register.enqueue(new Callback<RegisterResponseBody>() {
            @Override
            public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
                Log.d(TAG, "OnResponse");
                Log.d(TAG, String.format("Body : %s", response.body().toString()));
                Toast.makeText(MainActivity.this, "OnResponse", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "OnFailure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
