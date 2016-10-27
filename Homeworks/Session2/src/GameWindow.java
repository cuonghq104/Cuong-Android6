import controllers.*;
import controllers.Screens.LaunchScreen;
import controllers.Screens.PlayGameScreen;
import controllers.managers.*;
import models.GameConfig;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Cuong on 10/2/2016.
 */
public class GameWindow extends Frame implements Runnable, ScreenManager{

    Image backBufferImage;

    private int background_width = GameConfig.getInstance().getScreenWidth();

    private int background_height = GameConfig.instance.getScreenHeight();

    private GameScreen currentGameScreen;

    private Random r;

    int count;

    Stack<GameScreen> screenStack;

    public GameWindow() {

        count = 0;

        backBufferImage = new BufferedImage(background_width, background_height, BufferedImage.TYPE_INT_ARGB);

        r = new Random();

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

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    back();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addMouseListener(currentGameScreen);

        screenStack = new Stack<>();
        change(new LaunchScreen(this), false);
    }


    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        currentGameScreen.update(backBufferGraphics);

        g.drawImage(backBufferImage, 0, 0, background_width, background_height, null);
    }

    @Override
    public void run() {
        while (true) {
            currentGameScreen.run();
            repaint();
        }
    }

    public void back() {
        if (screenStack.size() > 0) {
            GameScreen newGameScreen = screenStack.pop();
            detach(currentGameScreen);
            attach(newGameScreen);
        }
    }
    @Override
    public void change(GameScreen gameScreen, boolean addToBackStack) {
        if (currentGameScreen != null) {
            this.detach(currentGameScreen);
        }
        if (addToBackStack && currentGameScreen != null) {
            screenStack.push(currentGameScreen );
        }
        this.attach(gameScreen);
    }

    private void attach(GameScreen newGameScreen) {
        this.currentGameScreen = newGameScreen;
        this.addMouseListener(newGameScreen);
        this.addKeyListener(newGameScreen);
        this.addMouseMotionListener(newGameScreen);
    }

    private void detach(GameScreen oldGameScreen) {
        this.removeKeyListener(oldGameScreen);
        this.removeMouseMotionListener(oldGameScreen);
        this.removeMouseListener(oldGameScreen);

    }
}
