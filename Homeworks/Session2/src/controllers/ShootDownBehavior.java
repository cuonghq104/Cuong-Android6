package controllers;

import controllers.managers.EnemyBulletControlManager;
import models.GameObject;

/**
 * Created by Cuong on 10/18/2016.
 */
public class ShootDownBehavior implements ShootBehavior{

    @Override
    public void doShoot(GameObject gameObject, EnemyBulletControlManager enemyBulletControlManager) {
        EnemyBulletController enemyBulletController =
                EnemyBulletController.create(gameObject.getX(), gameObject.getY(),
                        new FlyDownBehavior(2));
        enemyBulletControlManager.add(enemyBulletController);
    }
}
