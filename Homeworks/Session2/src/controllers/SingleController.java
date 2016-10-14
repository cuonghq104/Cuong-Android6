package controllers;

import models.GameObject;
import views.GameView;

import java.awt.*;

/**
 * Created by Cuong on 10/11/2016.
 */
public class SingleController implements BaseController{

    protected int dx;

    protected int dy;

    protected GameView gameView;

    protected GameObject gameObject;

    public GameObject getGameObject() {
        return gameObject;
    }

    public void draw(Graphics graphics) {
        gameView.drawImage(graphics, gameObject);
    }

    public SingleController(GameObject gameObject, GameView gameView) {
        this.gameView = gameView;
        this.gameObject = gameObject;
    }

    public void run() {

    }
}
