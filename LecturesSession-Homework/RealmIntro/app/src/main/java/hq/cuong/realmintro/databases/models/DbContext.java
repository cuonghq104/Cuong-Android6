package hq.cuong.realmintro.databases.models;

import android.content.Context;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Cuong on 12/6/2016.
 */
public class DbContext {
    private Realm realm;

    public void insert(Person person) {
        // 3: Add to realm
        realm.beginTransaction();
        realm.copyToRealm(person);
        realm.commitTransaction();
    }

    public List<Person> allPersons() {
        return realm.where(Person.class)
                .findAll();
    }

    public void update(Person person, String name) {
        realm.beginTransaction();
        person.setName(name);
        realm.commitTransaction();
    }

    public void delete(Person person) {
        realm.beginTransaction();
        person.deleteFromRealm();
        realm.commitTransaction();
    }

    private static DbContext instance;

    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new DbContext();
    }

    public DbContext() {
        realm = Realm.getDefaultInstance();
    }
}
