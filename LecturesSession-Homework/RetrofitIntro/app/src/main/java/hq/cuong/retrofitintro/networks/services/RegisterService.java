package hq.cuong.retrofitintro.networks.services;

import hq.cuong.retrofitintro.networks.jsonmodels.RegisterRequestBody;
import hq.cuong.retrofitintro.networks.jsonmodels.RegisterResponseBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Cuong on 12/6/2016.
 */
public interface RegisterService {

    @POST("/register")
    Call<RegisterResponseBody> register(@Body RequestBody body);
}
