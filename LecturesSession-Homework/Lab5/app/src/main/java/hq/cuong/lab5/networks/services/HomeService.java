package hq.cuong.lab5.networks.services;

import hq.cuong.lab5.networks.jsonmodels.HomeContentContainer;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Cuong on 12/11/2016.
 */
public interface HomeService {
    @POST("category/home")
    Call<HomeContentContainer> container(@Body RequestBody requestBody);
}
