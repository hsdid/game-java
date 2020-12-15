package com.company;

import java.awt.*;

public class Healkit extends GameObject{


    public Healkit(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.drawString("+",(int)x+10,(int)y +10);

        g.setColor(Color.GREEN);
        g.fillRect((int)x,(int)y,20, 20);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,20,20);
    }
}
