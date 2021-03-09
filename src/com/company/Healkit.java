package com.company;

import java.awt.*;

public class Healkit extends GameObject{


    public Healkit(float x, float y, int width, int height, ID id) {
        super(x, y,width,height, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.drawString("+",(int)x+10,(int)y +10);

        g.setColor(Color.GREEN);
        g.fillRect((int)x,(int)y,width, height);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,width,height);
    }
}
