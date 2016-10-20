package controllers;

import models.GameObject;
import models.Gift;
import utils.Utils;
import views.GameView;
import views.GiftView;

import java.awt.*;

/**
 * Created by Cuong on 10/20/2016.
 */
public class GiftController extends SingleController implements Contactable{

    public static final int SPEED = 2;

    public GiftController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }

    @Override
    public void run() {
        gameObject.move(0, SPEED);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
//        gameView.drawImage(graphics, gameObject);
    }


    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof PlaneController) {
            ((PlaneController) contactable).setPlaneShootingType(PlaneShootingType.DOUBLE);
        }
    }

    public static GiftController create(int x, int y) {
        return new GiftController(
                new Gift(x, y),
                new GiftView(Utils.loadImageFromRes("double_bullet.png"))
        );
    }
}
