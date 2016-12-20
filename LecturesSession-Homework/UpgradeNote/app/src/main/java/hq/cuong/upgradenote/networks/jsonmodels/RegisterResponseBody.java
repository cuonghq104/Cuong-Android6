package hq.cuong.upgradenote.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 12/18/2016.
 */
public class RegisterResponseBody {

    @SerializedName("result")
    private int result;

    @SerializedName("message")
    private String message;

    public RegisterResponseBody(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
