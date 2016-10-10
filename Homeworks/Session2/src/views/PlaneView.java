package views;

import models.Plane;

import java.awt.*;

/**
 * Created by Cuong on 10/9/2016.
 */
public class PlaneView {

    private Image image;

    public Image getImage() {
        return image;
    }

    public void drawImage(Graphics g, Plane plane) {
        g.drawImage(image, plane.getX(), plane.getY(), plane.PLANE_WIDTH, plane.PLANE_HEIGHT, null);
    }

    public PlaneView(Image image) {
        this.image = image;
    }
}
