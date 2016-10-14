package controllers;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Cuong on 10/11/2016.
 */

public class ControllerManager implements BaseController{

    private Vector<SingleController> singleControllers;

    public ControllerManager() {
        this.singleControllers = new Vector<>();
    }

    public void add(SingleController singleController) {
        singleControllers.add(singleController);
    }

    public Vector<SingleController> getSingleControllers() {
        return singleControllers;
    }

    @Override
    public void run() {
        for (SingleController singleController : singleControllers) {
            singleController.run();
        }
    }

    @Override
    public void draw(Graphics g) {
        for (SingleController singleController : singleControllers) {
            singleController.draw(g);
        }
    }

}
