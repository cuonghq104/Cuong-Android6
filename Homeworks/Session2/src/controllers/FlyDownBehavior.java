package controllers;

import models.GameObject;

/**
 * Created by Cuong on 10/18/2016.
 */
public class FlyDownBehavior implements FlyBehavior{

//    private static final int SPEED = 1;

    private int speed;

    public FlyDownBehavior(int speed) {
        this.speed = speed;
    }

    @Override
    public void doFly(GameObject gameObject) {
        gameObject.move(0, speed);
    }
}
