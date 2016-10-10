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
public class Enemy {

    public static final int ENEMY_WIDTH = 32;

    public static final int ENEMY_HEIGHT = 32;

    private final int SPEED = 2;

    private int x;

    private int y;

    ArrayList<Bullet> bullet;

    // Getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Constructer

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        bullet = new ArrayList<>();
    }

    public void fly() {
        y += SPEED;
    }


}
