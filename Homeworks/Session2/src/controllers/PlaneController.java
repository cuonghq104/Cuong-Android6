package controllers;

import models.*;
import utils.Utils;
import views.GameView;

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

    private BulletController bulletController;

    private PlaneShootingType planeShootingType;

    public PlaneController(Plane gameObject, GameView gameView) {
//        planeShootingType = new Pl
        super(gameObject, gameView);
        bulletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
//        bulletController = new BulletController()
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

            switch (planeShootingType) {
                case SINGLE:
                    bulletObject = new BulletSingle(gameObject.getX() + ((gameObject.getWidth() - BulletSingle.bullet_width) / 2), gameObject.getY() - BulletSingle.bullet_height);
                    imageBullet = Utils.loadImageFromRes("bullet.png");
                    break;
                case DOUBLE:
                    bulletObject = new BulletDouble(gameObject.getX() + ((gameObject.getWidth() - BulletDouble.bullet_width) / 2), gameObject.getY() - BulletSingle.bullet_height);
                    imageBullet = Utils.loadImageFromRes("double_bullet.png");
                    break;
            }
            bulletControllerManager.add(new BulletController(bulletObject, new GameView(imageBullet)));
            count = 0;
        }
    }

    public static final PlaneController planeController = new PlaneController(
        new Plane(GameConfig.instance.getScreenWidth() / 2, GameConfig.instance.getScreenHeight() - 100),
        new GameView(Utils.loadImageFromRes("plane3.png"))
    );

    public static final PlaneController planeControllerMouse = new PlaneController(
        new Plane(GameConfig.instance.getScreenWidth() / 2, GameConfig.instance.getScreenHeight() - 200),
        new GameView(Utils.loadImageFromRes("plane4.png"))
    );

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
    }

    public void setPlaneShootingType(PlaneShootingType planeShootingType) {
        this.planeShootingType = planeShootingType;
    }

}
