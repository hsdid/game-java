package com.company;

import java.awt.*;
import java.util.LinkedList;

public class Playyer extends GameObject {

    private Handler handler;
   // public int health = 100;
    private int timer;

    public Playyer(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32,32);
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

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.Enemy){
                //colision with BasicEnmy
                if (getBounds().intersects(tempObject.getBounds())){
                    if (HUD.HEALTH > 0)
                        HUD.HEALTH -= 2;

                }
            }

            if (tempObject.getId() == ID.EnemyBullet){
                //colision with bullet
                if (getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(tempObject);
                    if (HUD.HEALTH > 0)
                        HUD.HEALTH -= 10;

                }
            }
            if (tempObject.getId() == ID.Healkit){

                if (getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(tempObject);
                    if (HUD.HEALTH < 100)
                        HUD.HEALTH += 25;
                    if (HUD.HEALTH > 100)
                        HUD.HEALTH = 100;

                }
            }
        }
    }

    private void shoot() {




        if (shooting) {
            timer ++;
            if (timer >= 10){
                handler.addObject(new Bullet(x, y, ID.Bullet, handler, direction));
                timer = 0;
            }




        }
    }


    public void render(Graphics g) {
        //g.setColor(Color.white);
        //g.fillRect((int)x,(int)y,20,32);

        g.drawImage(Assets.player, (int)x,(int)y,20,32,null);

        if (direction == 1 ) {
            g.drawImage(Assets.player, (int)x,(int)y,20,32,null);
        } else if (direction == 2) {
            g.drawImage(Assets.playerRight, (int)x,(int)y,20,32,null);
        }

    }
}

