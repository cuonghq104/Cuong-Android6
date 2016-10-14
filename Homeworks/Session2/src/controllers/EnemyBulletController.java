package controllers;

import models.EnemyBullet;
import models.GameObject;
import views.EnemyBulletView;
import views.GameView;

import java.awt.*;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyBulletController extends SingleController{

    public static final int SPEED = 5;

    public EnemyBulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
    }

    public void draw(Graphics g) {
        gameView.drawImage(g, gameObject);
    }

    public void run() {
        gameObject.move(0, SPEED);
    }


}
