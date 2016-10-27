package controllers.managers;

import controllers.BaseController;
import controllers.Contactable;
import controllers.EnemyBulletController;
import models.GameObject;

import java.awt.*;

/**
 * Created by Cuong on 10/16/2016.
 */
public class EnemyBulletControlManager extends  ControllerManager implements Contactable {

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public GameObject getGameObject() {
        return null;
    }

    @Override
    public void onCollide(Contactable contactable) {

    }

    public void destroy() {
        for (BaseController baseController : baseControllers) {
            if (baseController instanceof EnemyBulletController) {
                ((EnemyBulletController) baseController).destroy();
            }
        }
    }
}
