package com.company;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject{



    public Enemy(int x, int y, ID id) {
        super(x, y, id);

    }



    public void tick() {



        if (x <= 0){
            x = 0;
            speedX = speedX * -1;
        }
        if (x >= 800){
            x = 800;
            speedX = speedX * -1;
        }
        if (y >= 450) {
            y = 450;
            speedY = speedY * -1;
        }
        if (y <= 0) {
            y = 0;
            speedY = speedY * -1;
        }

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
