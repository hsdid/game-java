package com.company;

import java.awt.*;

public class EnemyBullet extends GameObject{


    int direction;
    Handler handler;
    int width = 15;
    int hight = 15;
    float toX;
    float toY;



    public EnemyBullet(float x, float y, ID id, Handler handler,float toX, float toY){
        super(x,y,id);
        this.handler    = handler;

        this.toX        = toX;
        this.toY        = toY;
        speedX          = toX;
        speedY          = toY;
    }


    @Override
    public void tick() {
        //left

        x += speedX;
        y += speedY;



        if (y < 0 || y > GameMain.HEIGHT) handler.removeObject(this);
        if (x < 0 || x > GameMain.WIDTH) handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,width,hight);


    }



    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, width,hight);
    }
}
