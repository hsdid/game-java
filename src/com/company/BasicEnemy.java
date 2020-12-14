package com.company;

import java.awt.*;

public class BasicEnemy extends GameObject{

    Handler handler;
    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        speedX = 5;
        speedY = 5;
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        if (y <= 0 || y >= GameMain.HEIGHT - 52) speedY *= -1;
        if (x <= 0 || x >= GameMain.WIDTH - 32) speedX *= -1;

        collision();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,20,20);

    }
    private void collision() {
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Bullet){
                //colision with bullet
                if (getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(this);

                    HUD.score += 10;
                }
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,20,20);
    }
}
