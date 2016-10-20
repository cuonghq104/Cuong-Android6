package models;

/**
 * Created by Cuong on 10/20/2016.
 */
public class BulletSingle extends GameObject {

    public static int bullet_width = 13;

    public static int bullet_height = 33;

    public BulletSingle(int x, int y) {
        super(x, y, bullet_width, bullet_height);
    }
}
