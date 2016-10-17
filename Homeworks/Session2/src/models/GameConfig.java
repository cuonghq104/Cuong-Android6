package models;


/**
 *
 * Created by Cuong on 10/16/2016.
 */
public class GameConfig {
    private final static int DEFAULT_DELAY = 17;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;

    private int threadDelayInMilliseconds = 17;

    private int screenWidth;
    private int screenHeight;

    public double getSecond(int count) {
        return (threadDelayInMilliseconds * count) / 1000;
    }

    public double getMilliSecond(int count) {
        return threadDelayInMilliseconds * count;
    }

    private GameConfig(int threadDelayInMilliseconds, int screenWidth, int screenHeight) {
        this.threadDelayInMilliseconds = threadDelayInMilliseconds;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public static GameConfig instance; //

    public int getThreadDelayInMilliseconds() {
        return threadDelayInMilliseconds;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public static GameConfig getInstance() {
        if (instance == null) {
            instance = new GameConfig(DEFAULT_DELAY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
        return instance;
    }

//    public static final GameConfig instance = new GameConfig(
//            DEFAULT_DELAY,
//            DEFAULT_WIDTH,
//            DEFAULT_HEIGHT
//    );

    public boolean outsideScreenY(int y) {
        return (y < 0 || y > screenHeight);
    }

    public boolean yOutsideScreen(GameObject gameObject) {
        return outsideScreenY(gameObject.getY());
    }

}
