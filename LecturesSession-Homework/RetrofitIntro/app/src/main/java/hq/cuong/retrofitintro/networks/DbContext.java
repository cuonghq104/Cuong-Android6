package hq.cuong.retrofitintro.networks;

import java.util.List;

import hq.cuong.retrofitintro.networks.jsonmodels.Repo;
import hq.cuong.retrofitintro.networks.services.GithubService;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Cuong on 12/6/2016.
 */
public class DbContext {

    private static final Retrofit GITHUB  = new Retrofit.Builder()
        .baseUrl("http://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    public static Call<List<Repo>> getGithubRepository(String username) {
        return GITHUB.create(GithubService.class).listRepos(username);
    }
}
