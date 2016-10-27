package controllers;

import controllers.managers.CollisionPool;
import controllers.managers.ControllerManager;
import models.*;
import utils.Utils;
import views.SingleDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Cuong on 10/9/2016.
 */
public class PlaneController extends SingleController implements Contactable{

    private static final int SPEED = 10;
    private static final int RELOAD_TIME = 15;
    private int count;


    private ControllerManager bulletControllerManager;

//    private PlaneShootingType planeShootingType;

    private ShootingStyle shootingStyle;

    public PlaneController(Plane gameObject, SingleDrawer singleDrawer) {
        super(gameObject, singleDrawer);
        bulletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
        shootingStyle = ShootingStyle.SINGLE_BULLET;
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
            GameObject bulletObject = null;
            Image imageBullet = null;
            int x = 0;
            int y = 0;
            switch (shootingStyle) {
                case SINGLE_BULLET:
                    x = gameObject.getX() + ((gameObject.getWidth() - BulletSingle.bullet_width) / 2);
                    y = gameObject.getY() - BulletSingle.bullet_height;
                    break;
                case DOUBLE_BULLET:
                    x = gameObject.getX() + ((gameObject.getWidth() - BulletDouble.bullet_width) / 2);
                    y = gameObject.getY() - BulletSingle.bullet_height;
            }
            bulletControllerManager.add(BulletController.create(x, y, shootingStyle));
            count = 0;
        }
    }

    public static  PlaneController create(int x, int y, String res) {
        return new PlaneController(
                new Plane(x, y),
                new SingleDrawer(Utils.loadImageFromRes(res))
        );
    }

//    public static final PlaneController planeControllerMouse = new PlaneController(
//        new Plane(GameConfig.instance.getScreenWidth() / 2, GameConfig.instance.getScreenHeight() - 200),
//        new SingleDrawer(Utils.loadImageFromRes("plane4.png"))
//    );

    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof EnemyBulletController) {
            ((EnemyBulletController) contactable).destroy();
        }
        if (contactable instanceof GiftController) {
            ((GiftController) contactable).destroy();
        }
    }

    public void printHP() {
        System.out.println("HP left : " + ((Plane)gameObject).getHp());
    }

    public void getHit(int damage) {
        ((Plane)gameObject).getHit(damage);
        if (((Plane) gameObject).getHp() == 0) {
            this.destroy();
            ExplosionController.create(gameObject.getX(), gameObject.getY());
        }
    }

    public void setShootingStyle(ShootingStyle shootingStyle) {
        this.shootingStyle = shootingStyle;
    }
}
