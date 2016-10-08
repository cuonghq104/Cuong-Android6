import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Cuong on 10/2/2016.
 */
public class GameWindow extends Frame implements Runnable{

    Image backBufferImage;

    Image backgroundImage = null;

    Plane plane;
    Plane plane2;

    Bullet bullet;
    Bullet bullet2;

    private static final int BACKGROUND_WIDTH = 600;
    private static final int BACKGROUND_HEIGHT = 350;

    private static final int PLANE1_X = 300;
    private static final int PLANE1_Y = 200;

    private static final int PLANE2_X = 360;
    private static final int PLANE2_Y = 315;

    private static final int ENEMY_APPERENCE_FREQ = 2000;

    private long enemy_lastApperance;


    ArrayList<Enemy> enemy;

    public GameWindow() {


        backBufferImage = new BufferedImage(BACKGROUND_WIDTH, BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        try {

            bullet = new Bullet(0, 0, ImageIO.read(new File("resources/bullet.png")));

            bullet2 = new Bullet(0, 0, ImageIO.read(new File("resources/bullet.png")));

            plane = new Plane(PLANE1_X, PLANE1_Y,
                    ImageIO.read(new File("resources/plane3.png")));
            plane2 = new Plane(PLANE2_X, PLANE2_Y,
                    ImageIO.read(new File("resources/plane4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH,BACKGROUND_HEIGHT);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");
            }
        });


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                plane2.fire_LEFTCLICK(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2.mouseMoved(e);
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                plane.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });

        try {
            backgroundImage = ImageIO.read(
                    new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        enemy = new ArrayList<Enemy>();

        enemy_lastApperance = System.currentTimeMillis();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }


    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
        plane.drawImage(backBufferGraphics);
        plane2.drawImage(backBufferGraphics);

        for (int i = 0; i < enemy.size(); i++) {
            enemy.get(i).drawImage(backBufferGraphics);
        }

        for (int i = 0; i < plane.getBullet().size(); i++) {
            plane.getBullet().get(i).drawImage(backBufferGraphics);
        }

        for (int i = 0; i < plane2.getBullet().size(); i++) {
            plane2.getBullet().get(i).drawImage(backBufferGraphics);
        }

        for (int i = 0; i < enemy.size(); i++) {
            for (int j = 0; j < enemy.get(i).getBullet().size(); j++) {
                enemy.get(i).getBullet().get(j).drawImage(backBufferGraphics);
            }
        }

        g.drawImage(backBufferImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(17);

                for (int i = 0; i < plane.getBullet().size(); i++) {
                    plane.getBullet().get(i).move();
                }
                for (int i = 0; i < plane2.getBullet().size(); i++) {
                    plane2.getBullet().get(i).move();
                }

                long now = System.currentTimeMillis();
                if (now - enemy_lastApperance >= ENEMY_APPERENCE_FREQ) {
                    Random r = new Random();
                    int x = r.nextInt(BACKGROUND_WIDTH - Enemy.getENEMY_WIDTH());
                    enemy.add(new Enemy(x, 0, ImageIO.read(new File("resources/enemy_plane_white_2.png"))));
                    enemy_lastApperance = now;
                }

                for (int i = 0; i < enemy.size(); i++) {
                    enemy.get(i).move();
                }

                for (int i = 0; i < enemy.size(); i++) {
                    enemy.get(i).fire();
                }
//
                for (int i = 0; i < enemy.size(); i++) {
                    for (int j = 0; j < enemy.get(i).getBullet().size(); j++) {
                        enemy.get(i).getBullet().get(j).move_enemy();
                    }
                }

                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
