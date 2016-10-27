package controllers;

import controllers.managers.CollisionPool;
import controllers.managers.NotificationCenter;
import models.GameObject;
import utils.Utils;
import views.GameDrawer;
import views.SingleDrawer;

import java.awt.*;

/**
 * Created by Cuong on 10/20/2016.
 */
public class GiftController extends SingleController implements Contactable{
    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.register(this);
    }

    public static final int SPEED = 1;

    @Override
    public void run() {
        super.run();
        gameObject.move(0, SPEED);
    }

    public static GiftController create(int x, int y) {
        return new GiftController(
                new GameObject(x, y, 35, 40),
                new SingleDrawer(Utils.loadImageFromRes("bomb.png"))
        );
    }

    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof PlaneController) {
            NotificationCenter
                    .instance.onEvent(EventType.BOMB_EXPLOSE, this);
            this.destroy();
        }
    }

    public GiftController(GameObject gameObject, SingleDrawer gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }


    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
//        gameView.drawImage(graphics, gameObject);
    }


}
