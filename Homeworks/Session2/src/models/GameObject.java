package models;

/**
 * Created by Cuong on 10/11/2016.
 */
public class GameObject {

    protected int x;

    protected int y;

    private int width;

    private int height;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMiddleX() {
        return x + width / 2;
    }

    public int getMiddleY() {
        return y + height / 2;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBottom() {
        return y + height;
    }

    public int getRight() {
        return x + width;
    }
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void moveTo(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }


}