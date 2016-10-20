package controllers;

import models.*;
import utils.Utils;
import views.GameView;

import java.awt.*;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyPlaneController extends SingleController implements Contactable{


    EnemyBulletControlManager enemyBulletControlManager;

    private static final int SPEED = 1;

    private static final int RELOAD_TIME = 3000;

    private int counter;

    private FlyBehavior flyBehavior;

    private ShootBehavior shootBehavior;

    public EnemyPlaneController(GameObject gameObject, GameView gameView, FlyBehavior flyBehavior, ShootBehavior shootBehavior) {
        super(gameObject, gameView);
        counter = RELOAD_TIME;
        enemyBulletControlManager = new EnemyBulletControlManager();
        CollisionPool.instance.register(this);
        this.flyBehavior = flyBehavior;
        this.shootBehavior = shootBehavior;
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
        gameView.drawImage(g, gameObject);
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
        Image image = null;
        FlyBehavior flyBehavior = null;
        ShootBehavior shootBehavior = null;

        switch(enemyPlaneType) {
            case BLACK:
                image = Utils.loadImageFromRes("plane1.png");
                flyBehavior = new FlyDownBehavior(1);
                shootBehavior = new ShootDownBehavior();
                break;
            case WHITE:
                image = Utils.loadImageFromRes("enemy_plane_white_2.png");
                flyBehavior = new FlyDownRightBehavior(1);
                shootBehavior = new ShootDownRightBehavior();
                break;
            case YELLOW:
                image = Utils.loadImageFromRes("enemy_plane_yellow_1.png");
                flyBehavior = new FlyDownLeftBehavior(1);
                shootBehavior = new ShootDownLeftBehavior();
                break;
            case GREEN:
                image = Utils.loadImageFromRes("enemy_plane_green.png");
                flyBehavior = new FlyDownBehavior(1);
                shootBehavior = new ShootChaserBehavior();
                break;
        }
        return new EnemyPlaneController(
                new Enemy(x, y),
                new GameView(image),
                flyBehavior,
                shootBehavior);
    }


}
