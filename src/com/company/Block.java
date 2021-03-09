package com.company;

import java.awt.*;

public class Block extends GameObject{


    private Handler handler;

    public Block(float x, float y, int width, int height, ID id, Handler handler) {
        super(x, y,width,height, id);
        this.handler = handler;

    }

    @Override
    public void tick() {
        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Enemy || tempObject.getId() == ID.StrongerEnemy) {
                if (getBounds().intersects(tempObject.getBounds())){

                    if (tempObject.x+tempObject.width-5 <= x ) {
                        tempObject.x = x-tempObject.width;
                    }
                    if (tempObject.x > x+width-5) {
                        tempObject.x = x+width;
                    }


                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect((int)x,(int)y,width,height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,width,height);
    }
}
