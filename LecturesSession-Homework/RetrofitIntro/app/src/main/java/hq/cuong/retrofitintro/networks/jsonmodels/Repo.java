package hq.cuong.retrofitintro.networks.jsonmodels;

/**
 * Created by Cuong on 12/6/2016.
 */
public class Repo {

    private long id;

    private String name;

    private RepoOwner owner;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RepoOwner getOwner() {
        return owner;
    }

    class RepoOwner{

        private String login;

        private String avatarUrl;

        public String getLogin() {
            return login;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }
    }
}
