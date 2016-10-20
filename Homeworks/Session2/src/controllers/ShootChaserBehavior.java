package controllers;

import models.GameObject;

/**
 * Created by Cuong on 10/19/2016.
 */
public class ShootChaserBehavior implements ShootBehavior{

    @Override
    public void doShoot(GameObject gameObject, EnemyBulletControlManager enemyBulletControlManager) {
        EnemyBulletController enemyBulletController = EnemyBulletController.create(gameObject.getX(), gameObject.getY(), new FlyChaserBehavior(1, PlaneController.planeControllerMouse.gameObject, gameObject));
        enemyBulletControlManager.add(enemyBulletController);
    }
}
