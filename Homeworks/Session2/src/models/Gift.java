package models;

/**
 * Created by Cuong on 10/20/2016.
 */
public class Gift extends GameObject {

    public static final int GIFT_WIDTH = 30;
    public static final int GIFT_HEIGHT = 30;

    public Gift(int x, int y) {
        super(x, y, GIFT_WIDTH, GIFT_HEIGHT);
    }
}
