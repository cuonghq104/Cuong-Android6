package controllers;

import models.GameObject;

/**
 * Created by Cuong on 10/18/2016.
 */
public interface ShootBehavior{
    void doShoot(GameObject gameObject, EnemyBulletControlManager enemyBulletControlManager);
}
