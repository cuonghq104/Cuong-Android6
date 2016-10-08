import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/8/2016.
 */
public class Enemy {

    private static final int ENEMY_WIDTH = 32;

    private static final int ENEMY_HEIGHT = 32;
    private Image image;

    private final int ENEMY_SPEED = 300;

    private final int ENEMY_RELOAD_TIME = 1500;
    private int x;

    private int y;
    ArrayList<Bullet> bullet;

    private long last_time_move;

    private long last_time_fire;


    public ArrayList<Bullet> getBullet() {
        return bullet;
    }

    public static int getENEMY_WIDTH() {
        return ENEMY_WIDTH;
    }


    public Enemy(int x, int y, Image image) {
        this.image = image;
        this.x = x;
        this.y = y;
        bullet = new ArrayList<Bullet>();
        last_time_fire = System.currentTimeMillis();
        last_time_move = System.currentTimeMillis();
    }

    public void move() {
        long this_time_move = System.currentTimeMillis();
        if (this_time_move - last_time_move < ENEMY_SPEED) {
            return;
        }
        y += 10;
        last_time_move = this_time_move;
    }

    public void fire() {
        long this_time_fire = System.currentTimeMillis();
        if (this_time_fire - last_time_fire < ENEMY_RELOAD_TIME) {
            return;
        }
        last_time_fire = this_time_fire;
        try {
            bullet.add(new Bullet(x + (ENEMY_WIDTH - Bullet.BULLET_WIDTH) / 2, y,
                    ImageIO.read(new File("resources/enemy_bullet.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FIRE");
    }
    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, ENEMY_WIDTH, ENEMY_HEIGHT, null);
    }


}
