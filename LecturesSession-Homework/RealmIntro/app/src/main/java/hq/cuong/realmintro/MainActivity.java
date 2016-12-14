package hq.cuong.realmintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import hq.cuong.realmintro.databases.models.DbContext;
import hq.cuong.realmintro.databases.models.Person;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbContext.init(this);

        for (Person person : DbContext.getInstance().allPersons()) {
            Log.d(TAG, person.getName());
        }

    }


}
