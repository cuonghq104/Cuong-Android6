package views;

import models.Bullet;

import java.awt.*;

/**
 * Created by Cuong on 10/9/2016.
 */
public class BulletView {

    private Image image;

    public void drawImage(Graphics g, Bullet bullet) {
        g.drawImage(image, bullet.getX(), bullet.getY(), Bullet.BULLET_WIDTH, Bullet.BULLET_HEIGHT, null);
    }

    public Image getImage() {
        return image;
    }

    public BulletView(Image image) {
        this.image = image;
    }

}
