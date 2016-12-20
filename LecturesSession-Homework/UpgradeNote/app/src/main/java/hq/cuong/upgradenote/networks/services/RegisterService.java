package hq.cuong.upgradenote.networks.services;

import hq.cuong.upgradenote.networks.jsonmodels.RegisterResponseBody;
import hq.cuong.upgradenote.networks.jsonmodels.UserAccount;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Cuong on 12/18/2016.
 */
public interface RegisterService {
    @POST("register")
    Call<RegisterResponseBody> register (@Body RequestBody body);
}
