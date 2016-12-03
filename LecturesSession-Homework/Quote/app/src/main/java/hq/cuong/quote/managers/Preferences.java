package hq.cuong.quote.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Cuong on 12/2/2016.
 */
public class Preferences {
    private static final String KEY = "Quote";

    private static final String USERNAME_KEY = "username";

    private SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);

    }

    public String getUsername() {
        return sharedPreferences.getString(USERNAME_KEY, null);
    }

    public void putUsername(String username) {
        sharedPreferences.edit().putString(USERNAME_KEY, username).commit();
    }

    private static Preferences instance;

    public static Preferences getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new Preferences(context);
    }

}
