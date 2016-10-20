package controllers;

import models.GameObject;

/**
 * Created by Cuong on 10/18/2016.
 */
public class ShootDownLeftBehavior implements ShootBehavior{
    @Override
    public void doShoot(GameObject gameObject, EnemyBulletControlManager enemyBulletControlManager) {
        EnemyBulletController enemyBulletController =
                EnemyBulletController.create(gameObject.getX(), gameObject.getY(),
                        new FlyDownLeftBehavior(2));
        enemyBulletControlManager.add(enemyBulletController);
    }
}
