package controllers.managers;

import java.util.Stack;

/**
 * Created by Cuong on 10/25/2016.
 */
public interface ScreenManager {
     void change(GameScreen gameScreen, boolean addToBackStack);
}
