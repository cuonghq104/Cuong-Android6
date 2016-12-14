package hq.cuong.retrofitintro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 12/6/2016.
 */
public class RegisterResponseBody {

    @SerializedName("d")
    private User user;

    public User getUser() {
        return user;
    }

    public RegisterResponseBody(User user) {
        this.user = user;
    }
}
