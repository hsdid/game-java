package com.company;

import java.awt.*;

class Bullet extends GameObject{

    int direction;
    Handler handler;
    int width = 5;
    int hight = 20;

    public Bullet(int x, int y, ID id, Handler handler,int direction) {
        super(x, y, id);
        speedY = 10;
        speedX = 10;
        this.handler = handler;
        this.direction = direction;
    }

    @Override
    public void tick() {
        //left
        if (direction == 1){
            x -= speedX;
        }
        //right
        else if (direction == 2){
            x += speedX;
        }
        else if (direction == 3){
            y -= speedY;
        }
        else if (direction == 4){
            y += speedY;
        }

        if (y < 0) {
            handler.removeObject(this);

        }
        if (y < 0 || y > GameMain.HEIGHT) handler.removeObject(this);
        if (x < 0 || x > GameMain.WIDTH) handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.cyan);
        g.fillRect(x,y,5,20);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y, 5,20);
    }
}
