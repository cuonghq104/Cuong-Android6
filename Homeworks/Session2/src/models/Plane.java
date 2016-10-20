package models;

import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/4/2016.
 */
public class Plane extends GameObjectWithHp{

    public static final int PLANE_WIDTH = 60;
    public static final int PLANE_HEIGHT = 35;

    public static final int PLANE_HP = 3;

//    private int hp;

    public Plane(int x, int y) {
        super(x, y, PLANE_WIDTH, PLANE_HEIGHT, PLANE_HP);
        System.out.println(PLANE_HP);
//        hp = 3;
    }



    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
//
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void getHit(int damage) {
        decreaseHP(damage);
    }

}
