package models;

import controllers.EnemyBulletController;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/9/2016.
 */
public class EnemyBullet extends GameObject{

    public static final int BULLET_WIDTH = 32;
    public static final int BULLET_HEIGHT = 32;

    ArrayList<EnemyBulletController> arrayList;

    public EnemyBullet(int x, int y) {
        super(x, y, BULLET_WIDTH, BULLET_HEIGHT);
    }

}
