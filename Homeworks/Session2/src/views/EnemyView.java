package views;

import models.Enemy;

import java.awt.*;

/**
 * Created by Cuong on 10/10/2016.
 */
public class EnemyView {

    private Image image;

    public void drawImage(Graphics g, Enemy enemy) {
        g.drawImage(image, enemy.getX(), enemy.getY(), Enemy.ENEMY_WIDTH, Enemy.ENEMY_HEIGHT, null);
    }

    // Constructer
    public EnemyView(Image image) {
        this.image = image;
    }

    // Getter
    public Image getImage() {
        return image;
    }
}
