package controllers;

import models.Bullet;
import views.BulletView;

import java.awt.*;

/**
 * Created by Cuong on 10/9/2016.
 */
public class BulletController {

    Bullet bullet;

    BulletView bulletView;


    public BulletController(Bullet bullet, BulletView bulletView) {
        this.bullet = bullet;
        this.bulletView = bulletView;
    }

    public BulletView getBulletView() {
        return bulletView;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void draw(Graphics g) {
        bulletView.drawImage(g, bullet);
        // Views - models
    }

    public void run() {
        bullet.move();
    }


}
