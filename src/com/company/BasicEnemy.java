package com.company;

import java.awt.*;

public class BasicEnemy extends GameObject{

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        speedX = 5;
        speedY = 5;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        if (y <= 0 || y >= GameMain.HEIGHT - 32) speedY *= -1;
        if (x <= 0 || x >= GameMain.WIDTH - 32) speedX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,20,20);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,20,20);
    }
}
