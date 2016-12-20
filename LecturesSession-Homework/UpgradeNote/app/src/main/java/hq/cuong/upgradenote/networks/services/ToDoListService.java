package hq.cuong.upgradenote.networks.services;

import java.util.ArrayList;
import java.util.List;

import hq.cuong.upgradenote.networks.jsonmodels.LabNote;
import hq.cuong.upgradenote.networks.jsonmodels.ToDoResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Cuong on 12/18/2016.
 */
public interface ToDoListService {
    @GET("todos")
    Call<ArrayList<LabNote>> getList(@Header("token") String token);
}
