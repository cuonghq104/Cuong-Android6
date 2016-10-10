package models;

import java.awt.*;

/**
 * Created by Cuong on 10/4/2016.
 */
public class Bullet {
    private int x;

    private int y;

    public static final int BULLET_SPEED = 15;

    public static final int BULLET_WIDTH = 10;
    public static final int BULLET_HEIGHT = 30;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int getBulletHeight() {
        return BULLET_HEIGHT;
    }

    public void move() {
        y -= BULLET_SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
