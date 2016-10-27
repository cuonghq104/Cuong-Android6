package controllers.managers;

import controllers.BaseController;
import controllers.Contactable;
import models.GameObject;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Cuong on 10/16/2016.
 */
public class CollisionPool implements BaseController {
    private Vector<Contactable> contactableVector;

    private CollisionPool() {
        contactableVector = new Vector<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < contactableVector.size() - 1; i++) {
            for (int j = i + 1; j < contactableVector.size(); j++) {
                Contactable contactable1 =  contactableVector.get(i);
                Contactable contactable2 = contactableVector.get(j);

                GameObject gameObjecti = contactable1.getGameObject();
                GameObject gameObjectj = contactable2.getGameObject();
                if (gameObjecti.checkColliedWith(gameObjectj)) {
                    contactable1.onCollide(contactable2);
                    contactable2.onCollide(contactable1);
                }
            }
        }

        Iterator<Contactable> iterator = contactableVector.iterator();
        while (iterator.hasNext()) {
            Contactable baseController = iterator.next();
            if (!baseController.getGameObject().isAlive()) {
                iterator.remove();
            }
        }
    }


    @Override
    public void draw(Graphics g) {

    }

    public void register(Contactable contactable) {
        contactableVector.add(contactable);
    }

    public static final CollisionPool instance = new CollisionPool();

}
