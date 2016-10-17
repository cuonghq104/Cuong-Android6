package controllers;

import models.GameConfig;
import models.GameObject;
import views.GameView;

import java.awt.*;

/**
 * Created by Cuong on 10/9/2016.
 */
public class BulletController extends SingleController implements Contactable{


    public static final int SPEED = -10;

    public BulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
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
        }
    }
}
