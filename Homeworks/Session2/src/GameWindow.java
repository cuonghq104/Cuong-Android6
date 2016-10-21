import controllers.*;
import models.Enemy;
import models.GameConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Cuong on 10/2/2016.
 */
public class GameWindow extends Frame implements Runnable{

    Image backBufferImage;

    Image backgroundImage = null;

    private PlaneController planeController;
    private PlaneController planeControllerMouse;

    private GiftController giftController;

    private int background_width = GameConfig.getInstance().getScreenWidth();
    private int background_height = GameConfig.instance.getScreenHeight();

    private static final int ENEMY_APPERENCE_FREQ = 100;

    ControllerManager controllerManager;
    EnemyControllerManager enemyControllerManager;


    private long enemy_lastApperance;

    private Random r;

    int count;


    public GameWindow() {

        giftController = GiftController.create(GameConfig.getDefaultWidth() / 2, 10);

        count = 0;

        controllerManager = new ControllerManager();
        enemyControllerManager = new EnemyControllerManager();

        planeController = PlaneController.planeController;
        planeControllerMouse = PlaneController.planeControllerMouse;
        planeControllerMouse.setPlaneShootingType(PlaneShootingType.SINGLE);

        controllerManager.add(planeController);
        controllerManager.add(planeControllerMouse);
        controllerManager.add(enemyControllerManager);
        controllerManager.add(giftController);
        controllerManager.add(CollisionPool.instance);

        backBufferImage = new BufferedImage(background_width, background_height, BufferedImage.TYPE_INT_ARGB);

        r = new Random();

        enemy_lastApperance = ENEMY_APPERENCE_FREQ;


        this.setVisible(true);
        this.setSize(background_width,background_height);
        this.setLocation(300,0);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                planeControllerMouse.fire();
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
            }

            @Override
            public void keyPressed(KeyEvent e) {
                planeController.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    planeController.fire();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
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


//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//    }

    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(backgroundImage, 0, 0, background_width, background_height, null);

        enemyControllerManager.draw(backBufferGraphics);
        controllerManager.draw(backBufferGraphics);

        g.drawImage(backBufferImage, 0, 0, background_width, background_height, null);
    }

    @Override
    public void run() {
        while (true) {
//            giftController.run();
//            collieManager.run();
            FlyBehavior flyBehavior;
            ShootBehavior shootBehavior;
            EnemyPlaneController enemyPlaneController;
            if (enemy_lastApperance >= ENEMY_APPERENCE_FREQ) {
                count++;
                if (count % 4 == 0) {
                    enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.BLACK);
                } else if (count % 4 == 1) {
                    enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.WHITE);
                } else if (count % 4 == 2){
                    enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.YELLOW);
                } else {
                    enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.GREEN);
                }
                enemyControllerManager.add(enemyPlaneController);
//                enemyControllerManager.add(new EnemyPlaneController(
//                        new Enemy(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10),
//                        new GameView(Utils.loadImageFromRes("enemy_plane_yellow_1.png")),
//                        flyBehavior,
//                        shootBehavior
//                ));

                enemy_lastApperance = -1;
            }
            enemy_lastApperance++;

            try {
                Thread.sleep(GameConfig.getInstance().getThreadDelayInMilliseconds());
                repaint();

                controllerManager.run();
                enemyControllerManager.run();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
