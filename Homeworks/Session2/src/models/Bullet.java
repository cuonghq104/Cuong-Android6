package models;

import java.awt.*;

/**
 * Created by Cuong on 10/4/2016.
 */
public class Bullet extends GameObject{
    public static final int BULLET_SPEED = 20;

    public static final int BULLET_WIDTH = 10;
    public static final int BULLET_HEIGHT = 30;

    public static final int HP = 1;

    public Bullet(int x, int y) {
        super(x, y, BULLET_WIDTH, BULLET_HEIGHT, HP);
    }

    public void move() {
        y -= BULLET_SPEED;
    }
}
