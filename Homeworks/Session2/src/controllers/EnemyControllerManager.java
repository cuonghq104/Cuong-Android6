package controllers;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Cuong on 10/13/2016.
 */
public class EnemyControllerManager{

    Vector<EnemyController> enemyControllers;

    public EnemyControllerManager() {
        this.enemyControllers = new Vector<>();
    }

    public void add(EnemyController enemyController) {
        enemyControllers.add(enemyController);
    }

    public void run() {
        for (EnemyController enemyController : enemyControllers) {
            enemyController.run();
            enemyController.fire();
        }
    }

    public Vector<EnemyController> getEnemyControllers() {
        return enemyControllers;
    }

    public void draw(Graphics g) {
        for (EnemyController enemyController : enemyControllers) {
            enemyController.draw(g);
        }
    }


}
