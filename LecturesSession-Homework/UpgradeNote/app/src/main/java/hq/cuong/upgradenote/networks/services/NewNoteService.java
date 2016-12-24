package hq.cuong.upgradenote.networks.services;

import java.util.ArrayList;

import hq.cuong.upgradenote.networks.jsonmodels.LabNote;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Cuong on 12/23/2016.
 */
public interface NewNoteService {
    @POST("todos")
    Call<ArrayList<LabNote>> getList(@Header("token") String token, @Body RequestBody body);
}
