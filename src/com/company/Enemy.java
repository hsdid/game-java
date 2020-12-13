package com.company;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject{



    public Enemy(int x, int y, ID id) {
        super(x, y, id);

    }



    public void tick() {


        if (y <= 0 || y >= GameMain.HEIGHT - 32) speedY *= -1;
        if (x <= 0 || x >= GameMain.WIDTH - 32) speedX *= -1;

        x += speedX;
        y += speedY;


    }


    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
}
