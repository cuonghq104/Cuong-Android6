package controllers;

import controllers.managers.EnemyBulletControlManager;
import models.GameObject;

/**
 * Created by Cuong on 10/18/2016.
 */
public class ShootDownRightBehavior implements ShootBehavior{
    @Override
    public void doShoot(GameObject gameObject, EnemyBulletControlManager enemyBulletControlManager) {
        EnemyBulletController enemyBulletController =
                EnemyBulletController.create(gameObject.getX(), gameObject.getY(),
                        new FlyDownRightBehavior(2));
        enemyBulletControlManager.add(enemyBulletController);
    }
}
