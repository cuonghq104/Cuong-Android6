package models;

import models.Bullet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/8/2016.
 */
public class Enemy extends GameObject{

    public static final int ENEMY_WIDTH = 32;

    public static final int ENEMY_HEIGHT = 32;

    public static final int ENEMY_HP = 1;
    private final int SPEED = 2;

    ArrayList<Bullet> bullet;

    public Enemy(int x, int y) {
        super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
    }

    // Constructer

//    public Enemy(int x, int y) {
//        this.x = x;
//        this.y = y;
//        bullet = new ArrayList<>();
//    }



}
