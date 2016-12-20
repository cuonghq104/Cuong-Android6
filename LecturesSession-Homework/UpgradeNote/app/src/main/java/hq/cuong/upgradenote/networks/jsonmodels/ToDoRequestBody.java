package hq.cuong.upgradenote.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 12/18/2016.
 */
public class ToDoRequestBody {

    @SerializedName("token")
    private String token;

    public ToDoRequestBody(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
