package controllers;

import models.Bullet;
import models.Plane;
import utils.Utils;
import views.BulletView;
import views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by Cuong on 10/9/2016.
 */
public class PlaneController {

    private Plane plane;
    private PlaneView planeView;
    private int dx;
    private int dy;
    private static final int SPEED = 10;
    private static final int RELOAD_TIME = 10;
    private int count;

    private Vector<BulletController> vector;

    public PlaneController(Plane plane, PlaneView planeView) {
        vector = new Vector<>();
        this.plane = plane;
        this.planeView = planeView;
        count = RELOAD_TIME;
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                dx = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("KEY Left");
                dx = -SPEED;
                break;
            case KeyEvent.VK_UP:
                System.out.println("KEY UP");
                dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("KEY DOWN");
                dy = SPEED;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                dx = 0;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("KEY Left");
                dx = 0;
                break;
            case KeyEvent.VK_UP:
                System.out.println("KEY UP");
                dy = 0;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("KEY DOWN");
                dy = 0;
                break;
        }
    }

    public void run() {
        plane.move(dx, dy);
        for (int i = 0; i < vector.size(); i++) {
            vector.get(i).run();
        }
        count++;
    }


    public void draw(Graphics g) {
        planeView.drawImage(g, plane);
        for (int i = 0; i < vector.size(); i++) {
            vector.get(i).draw(g);
        }
    }

    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved");
        plane.moveTo(e.getX() - plane.PLANE_WIDTH / 2,
                e.getY() - plane.PLANE_HEIGHT / 2);
    }

    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
        if (count >= RELOAD_TIME) {
            fire(e);
            count = 0;
        }
    }

    public void fire(KeyEvent e) {
        if (count >= RELOAD_TIME) {
            vector.add(new BulletController(
                    new Bullet(plane.getX() + ((plane.PLANE_WIDTH - Bullet.BULLET_WIDTH) / 2), plane.getY() - Bullet.BULLET_HEIGHT),
                    new BulletView(Utils.loadImageFromRes("bullet.png"))
            ));
            count = 0;
        }
    }

    public void fire(MouseEvent e) {
        if (count >= RELOAD_TIME) {
            vector.add(new BulletController(
                    new Bullet(plane.getX() + ((plane.PLANE_WIDTH - Bullet.BULLET_WIDTH) / 2), plane.getY() - Bullet.BULLET_HEIGHT),
                    new BulletView(Utils.loadImageFromRes("bullet.png"))
            ));
            count = 0;
        }

    }

}
