package controllers;

import models.*;
import utils.Utils;
import views.EnemyBulletView;
import views.EnemyView;
import views.GameView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyPlaneController extends SingleController implements Contactable{


    EnemyBulletControlManager enemyBulletControlManager;

    private static final int SPEED = 1;

    private static final int RELOAD_TIME = 3000;

    private int counter;

    public EnemyPlaneController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        counter = RELOAD_TIME;
        enemyBulletControlManager = new EnemyBulletControlManager();
        CollisionPool.instance.register(this);
    }

    public void run() {
        gameObject.move(0, SPEED);
        enemyBulletControlManager.run();
        if (GameConfig.instance.getMilliSecond(counter) > RELOAD_TIME) {
            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new EnemyBullet(gameObject.getX() + (Enemy.ENEMY_WIDTH - EnemyBullet.BULLET_WIDTH) / 2, gameObject.getY() + EnemyBullet.BULLET_HEIGHT),
                    new GameView(Utils.loadImageFromRes("enemy_bullet.png"))
            );
            enemyBulletControlManager.add(enemyBulletController);
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
}
