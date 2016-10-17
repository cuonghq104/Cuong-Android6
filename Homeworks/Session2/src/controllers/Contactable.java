package controllers;

import models.GameObject;

/**
 * Created by Cuong on 10/16/2016.
 */
public interface Contactable {

    GameObject getGameObject();

    void onCollide(Contactable contactable);
}
