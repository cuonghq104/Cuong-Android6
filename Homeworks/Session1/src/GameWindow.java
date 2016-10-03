import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Cuong on 10/2/2016.
 */
public class GameWindow extends Frame{

    Image backgroundImage = null;

    Image plane3Image = null;
    private int plane1X;
    private int plane1Y;

    Image plane2Image = null;
    private int plane2X;
    private int plane2Y;

    public GameWindow() {
        plane1X = 300;
        plane1Y = 350;

        plane2X = 200;
        plane2Y = 200;

        this.setVisible(true);
        this.setSize(600,400);
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


        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("mouseMoved");
                plane2X = e.getX();
                plane2Y = e.getY();
                repaint();
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
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        plane1X += 10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("KEY Left");
                        plane1X -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        System.out.println("KEY UP");
                        plane1Y -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("KEY DOWN");
                        plane1Y += 10;
                        repaint();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });
        try {
            backgroundImage = ImageIO.read(
                    new File("resources/background.png"));

            plane3Image = ImageIO.read(
                    new File("resources/plane3.png"));

            plane2Image = ImageIO.read(
                    new File("resources/plane2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, 600, 400, null);
        g.drawImage(plane3Image, plane1X, plane1Y, 35, 25, null);
        g.drawImage(plane2Image, plane2X, plane2Y, 35, 25, null);
    }
}
