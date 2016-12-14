package hq.cuong.retrofitintro.networks.services;

import java.util.List;

import hq.cuong.retrofitintro.networks.jsonmodels.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Cuong on 12/6/2016.
 */
public interface GithubService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String userName);


}
