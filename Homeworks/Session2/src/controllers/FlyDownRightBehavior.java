package controllers;

import models.GameObject;

/**
 * Created by Cuong on 10/18/2016.
 */
public class FlyDownRightBehavior implements FlyBehavior{

//    public static final int SPEED = 1;

    public int speed ;

    public FlyDownRightBehavior(int speed) {
        this.speed = speed;
    }

    @Override
    public void doFly(GameObject gameObject) {
        gameObject.move(speed, speed);
    }
}
