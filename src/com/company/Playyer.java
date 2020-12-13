package com.company;

import java.awt.*;

public class Playyer extends GameObject {

    Handler handler;
    public int health = 100;

    public Playyer(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }

    public void tick() {

        x += speedX;
        y += speedY;

        if (x <= 0){
            x = 0;
        }
        if (x >= 800){
            x = 800;
        }
        if (y >= 450) {
            y = 450;

        }

        collision();



    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy){
                //colision with ball
                if (getBounds().intersects(tempObject.getBounds())){
                    if (HUD.HEALTH > 0)
                        HUD.HEALTH -= 2;
                    if (HUD.HEALTH == 0)
                        System.out.println("game over");
                }
            }
        }
    }

    private void shoot() {

    }



    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }
}
