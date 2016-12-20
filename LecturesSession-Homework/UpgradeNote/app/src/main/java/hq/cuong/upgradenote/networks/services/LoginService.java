package hq.cuong.upgradenote.networks.services;

import hq.cuong.upgradenote.networks.jsonmodels.LoginResponseBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Cuong on 12/18/2016.
 */
public interface LoginService {
    @POST("login")
    Call<LoginResponseBody> login (@Body RequestBody body);
}
