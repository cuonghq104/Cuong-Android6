package models;

/**
 * Created by Cuong on 10/18/2016.
 */
public class GameObjectWithHp extends GameObject {

    private int hp;

    public GameObjectWithHp(int x, int y, int width, int height, int hp) {
        super(x, y, width, height);
        System.out.println(hp);
        this.hp = hp;
        hp = hp;
    }

    public void decreaseHP(int amount) {
        hp -= amount;
        if (hp < 0) {
            isAlive = false;
        }
    }

    public void increaseHP (int amount) {
        hp += amount;
    }

    public int getHp() {
        return hp;
    }
}
