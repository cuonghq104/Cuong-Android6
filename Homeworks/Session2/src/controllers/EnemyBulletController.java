package controllers;

import models.EnemyBullet;
import views.EnemyBulletView;

import java.awt.*;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyBulletController {

    EnemyBullet enemyBullet;

    EnemyBulletView enemyBulletView;

    /* Constructer */

    public EnemyBulletController(EnemyBullet enemyBullet, EnemyBulletView enemyBulletView) {
        this.enemyBullet = enemyBullet;
        this.enemyBulletView = enemyBulletView;
    }

    /* Getter & Setter */

    public EnemyBullet getEnemyBullet() {
        return enemyBullet;
    }

    public EnemyBulletView getEnemyBulletView() {
        return enemyBulletView;
    }

    public void draw(Graphics g) {
        enemyBulletView.drawImage(g, enemyBullet);
    }

    public void run() {
        enemyBullet.move();
    }


}
