package models;

/**
 * Created by Cuong on 10/25/2016.
 */
public class Explosion extends GameObject {

    public static final int WIDTH = 32;

    public static final int HEIGHT = 32;
    public Explosion(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
