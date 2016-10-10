package controllers;

import models.Enemy;
import models.EnemyBullet;
import utils.Utils;
import views.EnemyBulletView;
import views.EnemyView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyController {

    private Enemy enemy;

    private EnemyView enemyView;

    ArrayList<EnemyBulletController> arrayList;

    private static final int RELOAD_TIME = 50;

    private int counter;

    /* Constructer */

    public EnemyController(Enemy enemy, EnemyView enemyView) {
        this.enemy = enemy;
        this.enemyView = enemyView;
        arrayList = new ArrayList<>();
        counter = RELOAD_TIME;
    }

    /* Getter & Setter */

    public Enemy getEnemy() {
        return enemy;
    }

    public EnemyView getEnemyView() {
        return enemyView;
    }

    public void run() {
        enemy.fly();
        for (EnemyBulletController enemyBulletController : arrayList) {
            enemyBulletController.run();
        }
    }

    public void fire() {
        if (counter == RELOAD_TIME) {
            arrayList.add(new EnemyBulletController(
                    new EnemyBullet(enemy.getX() + (Enemy.ENEMY_WIDTH - EnemyBullet.BULLET_WIDTH) / 2, enemy.getY() + EnemyBullet.BULLET_HEIGHT),
                    new EnemyBulletView(Utils.loadImageFromRes("enemy_bullet.png"))
            ));
            counter = -1;
        }
        counter++;
    }

    public void draw(Graphics g) {
        enemyView.drawImage(g, enemy);
        for (EnemyBulletController enemyBulletController : arrayList) {
            enemyBulletController.draw(g);
        }
    }


}
