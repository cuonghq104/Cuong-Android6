package controllers;

import models.EnemyBullet;
import models.GameObject;
import models.Plane;
import views.EnemyBulletView;
import views.GameView;

import java.awt.*;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyBulletController extends SingleController implements Contactable{

    public static final int SPEED = 2;

    public EnemyBulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }

    public void draw(Graphics g) {
        gameView.drawImage(g, gameObject);
    }

    public void run() {
        gameObject.move(0, SPEED);
    }


    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof PlaneController) {
            ((PlaneController) contactable).hit();
            ((PlaneController) contactable).printHP();
        }
    }
}
