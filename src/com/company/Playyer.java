package com.company;

import java.awt.*;

public class Playyer extends GameObject {


    public Playyer(int x, int y, ID id) {
        super(x, y, id);

    }

    public void tick() {

        x += speedX;
        y += speedY;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }
}
