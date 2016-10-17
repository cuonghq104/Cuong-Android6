package controllers;

import models.GameConfig;
import models.GameObject;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Cuong on 10/11/2016.
 */

public class ControllerManager implements BaseController{

    public Vector<BaseController> baseControllers;

    public ControllerManager() {
        this.baseControllers = new Vector<>();
    }

    public void add(BaseController baseController) {
        baseControllers.add(baseController);
    }

    public Vector<BaseController> getBaseControllers() {
        return baseControllers;
    }

    @Override
    public void run() {
        Iterator<BaseController> iterator = baseControllers.iterator();
        while (iterator.hasNext()) {
            BaseController baseController = iterator.next();
            if (baseController instanceof SingleController) {
                GameObject gameObject = ((SingleController) baseController).getGameObject();
                if (!gameObject.isAlive()) {
                    iterator.remove();
                } else {
                    baseController.run();
                }
            } else {
                baseController.run();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        for (BaseController baseController : baseControllers) {
            baseController.draw(g);
        }
    }

}
