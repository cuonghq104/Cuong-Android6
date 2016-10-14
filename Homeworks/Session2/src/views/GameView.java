package views;

import models.GameObject;
import models.Plane;

import java.awt.*;

/**
 * Created by Cuong on 10/11/2016.
 */
public class GameView {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void drawImage(Graphics g, GameObject gameObject) {
        g.drawImage(image, gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight(), null);
    }

    public GameView(Image image) {
        this.image = image;
    }
}
