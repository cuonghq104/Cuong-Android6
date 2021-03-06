package controllers;

import models.Explosion;
import models.GameObject;
import utils.Utils;
import views.AnimationDrawer;
import views.GameDrawer;

/**
 * Created by Cuong on 10/25/2016.
 */
public class ExplosionController extends SingleController {
    public ExplosionController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    public static ExplosionController create(int x, int y) {
        Utils.playSound("resources/Explosion.wav", false);
        return new ExplosionController(
                new Explosion(x, y),
                new AnimationDrawer(Utils.loadSprite("explosion.png", 6, 1, 1, 32, 32))
        );
    }

    @Override
    public void run() {
        super.run();
        int countRepeat  = ((AnimationDrawer)gameDrawer).getRepeatCount();
        if (countRepeat > 0 ) {
            gameObject.setAlive(false);
        }
    }
}
