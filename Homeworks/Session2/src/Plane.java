import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Cuong on 10/4/2016.
 */
public class Plane {

    public static final int PLANE_WIDTH = 60;
    public static final int PLANE_HEIGHT = 35;

    private int x;

    private int y;

    private Image image;

    private ArrayList<Bullet> bullet;

    private int attackSpeed;

    public ArrayList<Bullet> getBullet() {
        return bullet;
    }

    private long lastAttack;

    public Plane(int x, int y, Image image) {
        bullet = new ArrayList<Bullet>();
        lastAttack = System.currentTimeMillis();
        this.x = x;
        this.y = y;
        this.image = image;
        attackSpeed = 300;
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                x += 10;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("KEY Left");
                x -= 10;
                break;
            case KeyEvent.VK_UP:
                System.out.println("KEY UP");
                y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("KEY DOWN");
                y += 10;
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("FIRE SPACE");
                try {
                    long thisAttack = System.currentTimeMillis();
                    if (thisAttack - lastAttack < attackSpeed)
                        break;
                    lastAttack = thisAttack;
                    bullet.add(new Bullet(x + ((PLANE_WIDTH - Bullet.getBULLET_WIDTH()) / 2), y,
                            ImageIO.read(new File("resources/bullet.png"))));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }

    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved");
        x = e.getX() - PLANE_WIDTH / 2;
        y = e.getY() - PLANE_HEIGHT / 2;
    }


    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, PLANE_WIDTH, PLANE_HEIGHT, null);
    }

    public void fire_LEFTCLICK(MouseEvent e) {
        System.out.println("FIRE CLICK");
        try {
            bullet.add(new Bullet(x + ((PLANE_WIDTH - Bullet.getBULLET_WIDTH()) / 2), y,
                    ImageIO.read(new File("resources/bullet.png"))));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


}
