package controllers;

import controllers.managers.CollisionPool;
import models.EnemyBullet;
import models.GameConfig;
import utils.Utils;
import views.SingleDrawer;

import java.awt.*;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyBulletController extends SingleController implements Contactable{

    public static final int SPEED = 2;

    private FlyBehavior flyBehavior;

    public EnemyBulletController(EnemyBullet gameObject, SingleDrawer singleDrawer, FlyBehavior flyBehavior) {
        super(gameObject, singleDrawer);
        this.flyBehavior = flyBehavior;
        CollisionPool.instance.register(this);
    }

    public void draw(Graphics g) {
        gameDrawer.drawImage(g, gameObject);
    }

    public void run() {
//        gameObject.move(0, SPEED);
        if (flyBehavior != null) {
            flyBehavior.doFly(this.gameObject);
        }
        if (GameConfig.instance.yOutsideScreen(this.gameObject)) {
            this.destroy();
        }
    }


    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof PlaneController) {
            Utils.playSound("resources/Hit_Hurt8.wav", false);
            ((PlaneController) contactable).getHit(1);
            ((PlaneController) contactable).printHP();

        }
    }

    public static EnemyBulletController create(int x, int y, FlyBehavior flyBehavior) {
        EnemyBulletController enemyBulletController = new EnemyBulletController(
                new EnemyBullet(x, y),
                new SingleDrawer(Utils.loadImageFromRes("enemy_bullet.png")),
                flyBehavior
        );
        return enemyBulletController;
    }
}
