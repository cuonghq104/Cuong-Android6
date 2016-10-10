package models;

import controllers.EnemyBulletController;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/9/2016.
 */
public class EnemyBullet {

    private int x;

    private int y;

    public static final int SPEED_ENEMY_PLANE = 10;

    public static final int BULLET_WIDTH = 10;
    public static final int BULLET_HEIGHT = 30;

    ArrayList<EnemyBulletController> arrayList;

    /* Getter & Setter */

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public EnemyBullet(int x, int y) {
        this.x = x;
        this.y = y;
        arrayList = new ArrayList<>();
    }

    public void move() {
        y += SPEED_ENEMY_PLANE;
    }
}
