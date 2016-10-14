package controllers;

import models.Enemy;
import models.EnemyBullet;
import models.GameObject;
import utils.Utils;
import views.EnemyBulletView;
import views.EnemyView;
import views.GameView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyController extends SingleController {


    ControllerManager enemyBulletControlManager;

//    ControllerManager enemyBulletControlManager;

    private static final int SPEED = 2;

    private static final int RELOAD_TIME = 100;

    private int counter;

    public EnemyController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        counter = RELOAD_TIME;
        enemyBulletControlManager = new ControllerManager();
    }

    public void run() {
        gameObject.move(0, SPEED);
        enemyBulletControlManager.run();

    }

    public void fire() {
        if (counter == RELOAD_TIME) {
            enemyBulletControlManager.add(new EnemyBulletController(
                    new EnemyBullet(gameObject.getX() + (Enemy.ENEMY_WIDTH - EnemyBullet.BULLET_WIDTH) / 2, gameObject.getY() + EnemyBullet.BULLET_HEIGHT),
                    new GameView(Utils.loadImageFromRes("enemy_bullet.png"))
            ));
            counter = -1;
        }
        counter++;
    }

    public void draw(Graphics g) {
        gameView.drawImage(g, gameObject);
        enemyBulletControlManager.draw(g);
    }


}
