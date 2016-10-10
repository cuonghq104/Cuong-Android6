import controllers.EnemyController;
import controllers.PlaneController;
import models.Enemy;
import models.Plane;
import utils.Utils;
import views.EnemyView;
import views.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Cuong on 10/2/2016.
 */
public class GameWindow extends Frame implements Runnable{

    Image backBufferImage;

    Image backgroundImage = null;

    private PlaneController planeController;
    private PlaneController planeControllerMouse;

    Vector<EnemyController> vector;

    private static final int BACKGROUND_WIDTH = 600;
    private static final int BACKGROUND_HEIGHT = 350;

    private static final int ENEMY_APPERENCE_FREQ = 100;
    private static final int MILLIS_PER_FRAME = 17;

    private long enemy_lastApperance;


    private Random r;


    public GameWindow() {

        planeController = new PlaneController(
                new Plane(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT - 100),
                new PlaneView(Utils.loadImageFromRes("plane3.png"))
        );

        planeControllerMouse = new PlaneController(
                new Plane(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT - 200),
                new PlaneView(Utils.loadImageFromRes("plane4.png"))
        );

        vector = new Vector<>();

        backBufferImage = new BufferedImage(BACKGROUND_WIDTH, BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        r = new Random();

        enemy_lastApperance = ENEMY_APPERENCE_FREQ;

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
                planeControllerMouse.fire(e);
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
                planeControllerMouse.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                planeControllerMouse.mouseMoved(e);
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
                planeController.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    planeController.fire(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
                planeController.keyReleased(e);
            }
        });

        try {
            backgroundImage = ImageIO.read(
                    new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        planeController.draw(backBufferGraphics);
        planeControllerMouse.draw(backBufferGraphics);
        for (int i = 0; i < vector.size(); i++) {
            vector.get(i).draw(backBufferGraphics);
        }

        g.drawImage(backBufferImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }

    @Override
    public void run() {
        int now = ENEMY_APPERENCE_FREQ;
        while (true) {
            if (enemy_lastApperance >= ENEMY_APPERENCE_FREQ) {
                vector.add(new EnemyController(
                        new Enemy(r.nextInt(BACKGROUND_WIDTH) - Enemy.ENEMY_WIDTH, 10),
                        new EnemyView(Utils.loadImageFromRes("enemy_plane_yellow_1.png"))
                ));
                enemy_lastApperance = -1;
            }
            enemy_lastApperance++;

            try {
                Thread.sleep(MILLIS_PER_FRAME);
                repaint();

                planeController.run();
                planeControllerMouse.run();

                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i).run();
                }

                for (EnemyController enemyController : vector) {
                    enemyController.fire();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
