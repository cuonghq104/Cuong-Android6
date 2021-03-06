package controllers.Screens;

import controllers.managers.GameScreen;
import controllers.managers.ScreenManager;
import models.GameConfig;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Cuong on 10/27/2016.
 */
public class GameOverScreen extends GameScreen {
    public GameOverScreen(ScreenManager screenManager) {
        super(screenManager);
    }

    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(
                Utils.loadImageFromRes("negan-walking-dead1.jpg"),
                0,
                0,
                GameConfig.instance.getScreenWidth(),
                GameConfig.instance.getScreenHeight(),
                null
        );
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            this.screenManager.change(
                    new LaunchScreen(this.screenManager),
                    false
            );
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
