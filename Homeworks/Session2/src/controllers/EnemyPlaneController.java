package controllers;

import controllers.managers.CollisionPool;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyBulletControlManager;
import controllers.managers.NotificationCenter;
import models.*;
import utils.Utils;
import views.AnimationDrawer;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyPlaneController extends SingleController implements Contactable, Subscriber{


    EnemyBulletControlManager enemyBulletControlManager;

    private static final int SPEED = 1;

    private static final int RELOAD_TIME = 3000;

    private int counter;

    private FlyBehavior flyBehavior;

    private ShootBehavior shootBehavior;

    public EnemyPlaneController(GameObject gameObject, GameDrawer gameDrawer, FlyBehavior flyBehavior, ShootBehavior shootBehavior) {
        super(gameObject, gameDrawer);
        counter = RELOAD_TIME;
        enemyBulletControlManager = new EnemyBulletControlManager();
        CollisionPool.instance.register(this);
        this.flyBehavior = flyBehavior;
        this.shootBehavior = shootBehavior;
        NotificationCenter.instance.register(this);
    }





    public void run() {

        if (GameConfig.instance.yOutsideScreen(this.gameObject)) {
            this.destroy();
        }
        if (this.flyBehavior != null)
            this.flyBehavior.doFly(this.gameObject);
        enemyBulletControlManager.run();

        if (flyBehavior instanceof FlyDownLeftBehavior && gameObject.getX() == 0) {
            flyBehavior = new FlyDownRightBehavior(1);
            shootBehavior = new ShootDownRightBehavior();
        }

        if (flyBehavior instanceof FlyDownRightBehavior && gameObject.getX() == GameConfig.getDefaultWidth() - Enemy.ENEMY_WIDTH) {
            flyBehavior = new FlyDownLeftBehavior(1);
            shootBehavior = new ShootDownLeftBehavior();
        }

        if (GameConfig.instance.getMilliSecond(counter) > RELOAD_TIME) {
            if (shootBehavior != null) {
                shootBehavior.doShoot(this.gameObject, this.enemyBulletControlManager);
            }
            counter = -1;
        }
        counter++;

    }

    public void draw(Graphics g) {
        gameDrawer.drawImage(g, gameObject);
        enemyBulletControlManager.draw(g);
    }


    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof BulletController) {
            ((BulletController) contactable).destroy();
            enemyBulletControlManager.destroy();
        }
    }

    public static EnemyPlaneController create(int x, int y, EnemyPlaneType enemyPlaneType) {
//        Image image = null;
        AnimationDrawer animationDrawer = null;

        FlyBehavior flyBehavior = null;
        ShootBehavior shootBehavior = null;

        switch(enemyPlaneType) {
            case BLACK:
//                image = Utils.loadImageFromRes("plane1.png");
//                flyBehavior = new FlyDownBehavior(1);
//                shootBehavior = new ShootDownBehavior();
//                break;
            case RED:
                String[] arrName = {"red_1.png", "red_2.png", "red_3.png"};
                animationDrawer = new AnimationDrawer(arrName);
                flyBehavior = new FlyDownRightBehavior(1);
                shootBehavior = new ShootDownRightBehavior();
                break;
            case GREEN:
                arrName = new String[]{"enemy4_1.png", "enemy4_2.png", "enemy4_3.png"};
                animationDrawer = new AnimationDrawer(arrName);
                flyBehavior = new FlyDownBehavior(1);
                shootBehavior = new ShootDownBehavior();
                break;
            case YELLOW:
//                image = Utils.loadImageFromRes("enemy_plane_yellow_1.png");
                arrName = new String[]{"enemy_plane_yellow_1.png", "enemy_plane_yellow_2.png", "enemy_plane_yellow_3.png"};
                animationDrawer = new AnimationDrawer(arrName);
                flyBehavior = new FlyDownLeftBehavior(1);
                shootBehavior = new ShootDownLeftBehavior();
        }
        return new EnemyPlaneController(
                new Enemy(x, y),
                animationDrawer,
                flyBehavior,
                shootBehavior);
    }

    private static final int DAMAGE_RADIUS = 200;

    @Override
    public void onEvent(EventType eventType, SingleController singleController) {
        if (eventType == EventType.BOMB_EXPLOSE) {
            GameObject gameObject = singleController.getGameObject();
            double distance = Utils.distance(this.gameObject, gameObject);
            if (distance < DAMAGE_RADIUS) {
                this.destroy();
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ExplosionController explosionController = ExplosionController.create(gameObject.getX(), gameObject.getY());
        ControllerManager.explosionManager.add(explosionController);
        NotificationCenter.instance.unregister(this);
    }
}
