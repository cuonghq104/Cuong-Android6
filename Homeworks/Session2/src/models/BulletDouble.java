package models;

/**
 * Created by Cuong on 10/20/2016.
 */
public class BulletDouble extends GameObject {

    public static int bullet_width = 26;

    public static int bullet_height = 33;

    public BulletDouble(int x, int y) {
        super(x, y, bullet_width, bullet_height);
    }

}
