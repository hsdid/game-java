package com.company;

import java.awt.*;

public class EnemyBullet extends GameObject{



    private Handler handler;




    public EnemyBullet(float x, float y, int width, int height, ID id, Handler handler,float toX, float toY){
        super(x,y, width, height, id);
        this.handler    = handler;
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
        g.fillRect((int)x,(int)y,width,height);


    }



    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, width,height);
    }
}
