package controllers;

import models.Bullet;
import models.GameObject;
import utils.Utils;
import views.GameView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by Cuong on 10/9/2016.
 */
public class PlaneController extends SingleController {

    private static final int SPEED = 10;
    private static final int RELOAD_TIME = 15;
    private int count;


    ControllerManager bulletControllerManager;

    public PlaneController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        bulletControllerManager = new ControllerManager();
    }

    public ControllerManager getBulletControllerManager() {
        return bulletControllerManager;
    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                dx = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                dx = -SPEED;
                break;
            case KeyEvent.VK_UP:
                dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                dy = SPEED;
                break;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        bulletControllerManager.draw(graphics);
    }

    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                dx = 0;
                break;
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;
            case KeyEvent.VK_UP:
                dy = 0;
                break;
            case KeyEvent.VK_DOWN:
                dy = 0;
                break;
        }
    }

    @Override
    public void run() {
        gameObject.move(dx, dy);
        bulletControllerManager.run();

        count++;
    }


    public void mouseMoved(MouseEvent e) {
        gameObject.moveTo(e.getX() - gameObject.getWidth() / 2,
                e.getY() - gameObject.getHeight() / 2);
    }

    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
        if (count >= RELOAD_TIME) {
            fire();
            count = 0;
        }
    }

    public void fire() {
        if (count >= RELOAD_TIME) {
            bulletControllerManager.add(new BulletController(
                    new Bullet(gameObject.getX() + ((gameObject.getWidth() - Bullet.BULLET_WIDTH) / 2), gameObject.getY() - Bullet.BULLET_HEIGHT),
                    new GameView(Utils.loadImageFromRes("bullet.png"))
            ));
            count = 0;
        }
    }

}
