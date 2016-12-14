package hq.cuong.lab5.databases;

import android.content.Context;

import hq.cuong.lab5.networks.jsonmodels.HomeContentContainer;
import io.realm.Realm;

/**
 * Created by Cuong on 12/11/2016.
 */
public class DbContext {

    private Realm realm;

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

    public void insert(HomeContentContainer homeContentContainer) {
        realm.beginTransaction();
        realm.copyToRealm(homeContentContainer);
        realm.commitTransaction();
    }

    public void clearRealm() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public HomeContentContainer allContent() {
        return realm.where(HomeContentContainer.class).findFirst();
    }

    public int getSize() {
        return realm.where(HomeContentContainer.class).findAll().size();
    }
}
