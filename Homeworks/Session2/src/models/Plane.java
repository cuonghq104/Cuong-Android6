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
public class Plane extends GameObject{

    public static final int PLANE_WIDTH = 60;
    public static final int PLANE_HEIGHT = 35;

    public Plane(int x, int y) {
        super(x, y, PLANE_WIDTH, PLANE_HEIGHT);
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

}
