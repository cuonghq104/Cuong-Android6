package models;

import java.awt.*;

/**
 * Created by Cuong on 10/11/2016.
 */
public class GameObject {

    protected int x;

    protected int y;

    protected int hp;

    private int width;

    private int height;

    private boolean isAlive;

    public GameObject(int x, int y, int width, int height, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hp = hp;
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHp() {
        return hp;
    }

    public void hit() {
        if (hp < 1)
            return;
        hp--;
        if (hp == 0) {
            isAlive = false;
        }
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

    private Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public boolean checkColliedWith(GameObject gameObject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }

}
