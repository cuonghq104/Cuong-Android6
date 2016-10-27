package controllers.Screens;

import controllers.*;
import controllers.managers.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.Enemy;
import models.GameConfig;
import models.Gift;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Cuong on 10/25/2016.
 */
public class PlayGameScreen extends GameScreen {
    Image backgroundImage = null;
    private PlaneController planeController;
    private PlaneController planeControllerMouse;
    private ControllerManager controllerManager;
    private EnemyControllerManager enemyControllerManager;
    private GiftController giftController;
    private long enemy_lastApperance;
    private static final int ENEMY_APPERENCE_FREQ = 100;
    private int count;
    private int background_width = GameConfig.getInstance().getScreenWidth();
    Random r;
    EnemyPlaneController enemyPlaneController;

    private int background_height = GameConfig.instance.getScreenHeight();

    public PlayGameScreen(ScreenManager screenManager) {
        super(screenManager);
        controllerManager = new ControllerManager();
        giftController = GiftController.create(GameConfig.getDefaultWidth() / 2, 10);

        enemyControllerManager = new EnemyControllerManager();
        planeController = PlaneController.create(GameConfig.instance.getScreenWidth() / 2, GameConfig.instance.getScreenHeight() - 200, "plane3.png");
        planeControllerMouse = PlaneController.create(GameConfig.instance.getScreenWidth() / 2, GameConfig.instance.getScreenHeight() - 100, "plane2.png");
        planeControllerMouse.setShootingStyle(ShootingStyle.SINGLE_BULLET);

        controllerManager.add(planeController);
        controllerManager.add(planeControllerMouse);
        controllerManager.add(enemyControllerManager);
//        controllerManager.add(giftController);
        controllerManager.add(GiftController.create(30, 30));
        controllerManager.add(CollisionPool.instance);
        controllerManager.add(ControllerManager.explosionManager);
        try {
            backgroundImage = ImageIO.read(
                    new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        count = 0;
        enemy_lastApperance = ENEMY_APPERENCE_FREQ;
        r = new Random();
        enemy_lastApperance = System.currentTimeMillis();
        Utils.playSound("resources/GameofThrones.wav", true);
    }

    @Override
    public void run() {
        if (!planeController.getGameObject().isAlive() || !planeControllerMouse.getGameObject().isAlive()) {
            this.screenManager.change(new GameOverScreen(screenManager),
                    false);
        }
        if (enemy_lastApperance >= ENEMY_APPERENCE_FREQ) {
            count++;
            if (count % 4 == 0) {
                enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.YELLOW);
            } else if (count % 4 == 1) {
                enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.GREEN);
            } else if (count % 4 == 2){
                enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.RED);
            } else {
                enemyPlaneController = EnemyPlaneController.create(r.nextInt(background_width) - Enemy.ENEMY_WIDTH, 10, EnemyPlaneType.YELLOW);
            }
            enemyControllerManager.add(enemyPlaneController);

            enemy_lastApperance = -1;
        }
        enemy_lastApperance++;

        try {
            Thread.sleep(GameConfig.getInstance().getThreadDelayInMilliseconds());
            controllerManager.run();
            enemyControllerManager.run();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(backgroundImage, 0, 0, GameConfig.instance.getScreenWidth(), GameConfig.instance.getScreenHeight(), null);

        enemyControllerManager.draw(graphics);
        controllerManager.draw(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        planeController.keyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            planeController.fire();
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            this.screenManager.change(new LaunchScreen(screenManager), false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        planeController.keyReleased(e);
    }

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

    @Override
    public void mouseDragged(MouseEvent e) {
        planeControllerMouse.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        planeControllerMouse.mouseMoved(e);
    }
}
