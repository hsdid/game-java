package com.company;

import java.awt.*;

class Bullet extends GameObject{

    Handler handler;
    public Bullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        speedY = 10;
        this.handler = handler;
    }

    @Override
    public void tick() {
        //x += speedX;
        y -= speedY;
        if (y < 0) {
            handler.removeObject(this);

        }
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.green);
        g.fillRect(x,y,5,20);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y, 15,15);
    }
}
