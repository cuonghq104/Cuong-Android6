package views;

import models.GameConfig;
import models.GameObject;
import utils.Utils;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Cuong on 10/25/2016.
 */
public class AnimationDrawer extends GameDrawer {
    private Vector<Image>imageVector;

    private int index = 0;

    private int count = 0;

    private int repeatCount = 0;


    public int getRepeatCount() {
        return repeatCount;
    }

    public AnimationDrawer(String[] arrName) {
        this.imageVector = new Vector<>();
        for (String name : arrName) {
            Image image = Utils.loadImageFromRes(name);
            imageVector.add(image);
        }
    }

    public AnimationDrawer(Vector<Image>vector) {
        this.imageVector = vector;
    }

    @Override
    public void drawImage(Graphics g, GameObject gameObject) {
        Image image = imageVector.get(index);
        g.drawImage(image, gameObject.getX(),
                gameObject.getY(),
                gameObject.getWidth(),
                gameObject.getHeight(),
                null);

        count++;
        if (GameConfig.instance.getMilliSecond(count) > 50) {
            index++;
//            index = index % imageVector.size();
            if (index >= imageVector.size()) {
                index = 0;
                repeatCount++;
            }
            count = 0;
        }
    }
}
