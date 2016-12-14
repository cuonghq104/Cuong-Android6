package hq.cuong.realmintro.databases.models;

import io.realm.RealmObject;

/**
 * Created by Cuong on 12/6/2016.
 */
public class Person extends RealmObject{
    private String name;

    public static Person create(String name) {
        Person person = new Person();
        person.name = name;
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
