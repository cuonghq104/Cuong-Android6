package hq.cuong.upgradenote.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Cuong on 12/18/2016.
 */
public class Preferences {

    private static final String KEY = "Note";

    private static final String TOKEN_KEY = "token";

    private SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);

    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN_KEY, null);
    }

    public void putToken(String token) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).commit();
    }

    private static Preferences instance;

    public static Preferences getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new Preferences(context);
    }
}
