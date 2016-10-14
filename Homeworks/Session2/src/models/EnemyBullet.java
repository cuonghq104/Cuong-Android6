package models;

import controllers.EnemyBulletController;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/9/2016.
 */
public class EnemyBullet extends GameObject{

    public static final int SPEED_ENEMY_PLANE = 10;

    public static final int BULLET_WIDTH = 10;
    public static final int BULLET_HEIGHT = 30;

    ArrayList<EnemyBulletController> arrayList;

    public EnemyBullet(int x, int y) {
        super(x, y, BULLET_WIDTH, BULLET_HEIGHT);
    }

    /* Getter & Setter */

//    public EnemyBullet(int x, int y) {
//        this.x = x;
//        this.y = y;
//        arrayList = new ArrayList<>();
//    }
//
//    public void move() {
//        y += SPEED_ENEMY_PLANE;
//    }
}
