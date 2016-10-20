package controllers;

import models.GameObject;
import models.Plane;

import static controllers.PlaneController.planeController;

/**
 * Created by Cuong on 10/19/2016.
 */
public class FlyChaserBehavior implements FlyBehavior{

    private int speed;

    private int x;
    private int y;

    private int ratio;
    private boolean leftSide;
    private boolean upSide;
    public FlyChaserBehavior(int speed, GameObject plane, GameObject enemy) {
        this.speed = speed;
        x = plane.getX() - enemy.getX();
        if (x < 0) {
            leftSide = true;
        } else {
            leftSide = false;
        }
        y = plane.getY() - enemy.getY();
        if (y > 0) {
            upSide = false;
        } else {
            upSide = true;
        }
        ratio = y / x;
    }

    @Override
    public void doFly(GameObject gameObject) {
        if (!leftSide && !upSide) {
            gameObject.move(speed, Math.abs(ratio) * speed);
            System.out.println("RIGHT - DOWN");
        }else if (leftSide && !upSide) {
            gameObject.move(-speed, Math.abs(ratio) * speed);
            System.out.println("LEFT - DOWN");
        }else if (!leftSide && upSide) {
            System.out.println("RIGHT - UP");
            gameObject.move(speed, -Math.abs(ratio) * speed);
        } else {
            System.out.println("LEFT - UP");
            gameObject.move(-speed, -Math.abs(ratio) * speed);
        }
    }
}
