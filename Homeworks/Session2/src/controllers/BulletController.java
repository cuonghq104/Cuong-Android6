package controllers;

import controllers.managers.CollisionPool;
import controllers.managers.ControllerManager;
import models.BulletDouble;
import models.BulletSingle;
import models.GameConfig;
import models.GameObject;
import utils.Utils;
import views.SingleDrawer;

/**
 * Created by Cuong on 10/9/2016.
 */
public class BulletController extends SingleController implements Contactable{


    public static final int SPEED = -10;

    public BulletController(GameObject gameObject, SingleDrawer singleDrawer) {
        super(gameObject, singleDrawer);
        CollisionPool.instance.register(this);
    }
    @Override
    public void run() {
        gameObject.move(0, SPEED);
        if (GameConfig.instance.yOutsideScreen(this.gameObject)) {
            this.destroy();
        }
    }

    public void onCollide(Contactable contactable) {
        if (contactable instanceof EnemyPlaneController) {
            ((EnemyPlaneController) contactable).destroy();
//            ExplosionController explosionController = ExplosionController.create(gameObject.getX(), gameObject.getY());
//            ControllerManager.explosionManager.add(explosionController);
        }
    }

    public static BulletController create(int x, int y, ShootingStyle shootingStyle) {
        Utils.playSound("resources/Laser_Shoot5.wav", false);
        switch (shootingStyle) {
            case DOUBLE_BULLET:
                return new BulletController(
                        new BulletDouble(x, y),
                        new SingleDrawer(Utils.loadImageFromRes("double_bullet.png"))
                );
            default:
            return new BulletController(
                        new BulletSingle(x, y),
                        new SingleDrawer(Utils.loadImageFromRes("bullet.png"))
                );
        }
    }
}
