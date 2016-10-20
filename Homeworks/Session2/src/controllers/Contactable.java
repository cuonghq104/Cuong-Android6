package controllers;

import models.GameObject;

public interface Contactable {

    GameObject getGameObject();

    void onCollide(Contactable contactable);

}
