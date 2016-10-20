package models;

/**
 * Created by Cuong on 10/4/2016.
 */
public class Bullet extends GameObject{
    public static final int BULLET_SPEED = 20;

    public static int bullet_width = 13;
    public static int bullet_height = 33;

    public Bullet(int x, int y) {
        super(x, y, bullet_width, bullet_height);
    }

    public void move() {
        y -= BULLET_SPEED;
    }
}
