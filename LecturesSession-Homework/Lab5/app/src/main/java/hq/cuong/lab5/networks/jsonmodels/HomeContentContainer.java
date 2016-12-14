package hq.cuong.lab5.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Cuong on 12/11/2016.
 */
public class HomeContentContainer extends RealmObject {

    @SerializedName("d")
    RealmList<HomeContent> homeContent;

    public HomeContentContainer(RealmList<HomeContent> homeContent) {
        this.homeContent = homeContent;
    }

    public RealmList<HomeContent> getHomeContent() {
        return homeContent;
    }

    public HomeContentContainer() {
    }

    @Override
    public String toString() {
        return "HomeContentContainer{" +
                "homeContent=" + homeContent +
                '}';
    }
}
