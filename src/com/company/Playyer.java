package com.company;

import java.awt.*;
import java.util.LinkedList;

public class Playyer extends GameObject {

    Handler handler;
    public int health = 100;
    public int bullets;
    public static int direction;



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
        if (x >= GameMain.WIDTH - 52){
            x = GameMain.WIDTH - 52;
        }
        if (y <= 0){
            y = 0;
        }
        if (y >= GameMain.HEIGHT - 72){
            y = GameMain.HEIGHT - 72;
        }

        collision();
        shoot();

    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy){
                //colision with BasicEnmy
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


        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Bullet){
                bullets++;
            }
        }

        if (shooting) {

            if (bullets <= 5) {

                handler.addObject(new Bullet(x, y, ID.Bullet, handler,direction));
            }
            else
                bullets = 0;
        }
    }


    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }
}

