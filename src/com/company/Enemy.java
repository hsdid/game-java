package com.company;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject{

    private int health;
    Handler handler;
    private GameObject player;
    private int width=20, height=32;

    public Enemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
        this.health = 4;
        //get player rom object list
        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player)
                player = handler.object.get(i);
        }

    }


    public void tick() {

        x += speedX;
        y += speedY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;

        float distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));

        speedX = (float) ((-1.0/distance) * diffX);
        speedY = (float) ((-1.0/distance) * diffY);

        if (y <= 0 || y >= GameMain.HEIGHT - 32) speedY *= -1;
        if (x <= 0 || x >= GameMain.WIDTH - 32) speedX *= -1;

        collision();


    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Bullet){
                //colision with bullet
                if (getBounds().intersects(tempObject.getBounds())){
                    //handler.removeObject(this);
                    speedX = 0;
                    speedY = 0;

                    this.health -= 1;
                    handler.removeObject(tempObject);
                    if (this.health <= 0) {
                        handler.removeObject(this);
                        HUD.score += 10;
                    }

                }
            }
            if (tempObject.getId() == ID.Enemy) {

            }
        }
    }


    public void render(Graphics g) {
        //g.setColor(Color.PINK);
        //g.fillRect((int)x,(int)y,20, 20);

        g.drawImage(Assets.zombie, (int)x,(int)y,width,height,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,width,height);
    }
}
