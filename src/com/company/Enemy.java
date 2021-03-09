package com.company;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject{

    private int health;
    Handler handler;
    private GameObject player;
    private GameObject player2;

    //private int width=20, height=32;

    public Enemy(float x, float y, int width, int height, ID id, Handler handler) {
        super(x, y,width,height, id);

        this.handler = handler;
        this.health  = 4;

        //get player from object list
        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player)
                player  = handler.object.get(i);

            if (handler.object.get(i).getId() == ID.Player2) {
                player2 = handler.object.get(i);
            }
        }
    }


    public void tick() {

        x += speedX;
        y += speedY;

        if ( player2 == null ){
            enemyMoveOnePlayer();
        } else {
            enemyMove2Players();
        }

        if (y <= 0 || y >= GameMain.HEIGHT - 32) speedY *= -1;
        if (x <= 0 || x >= GameMain.WIDTH - 32) speedX *= -1;

        collision();



    }

    private void enemyMoveOnePlayer(){
        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;

        float distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));

        speedX = (float) ((-1.0/distance) * diffX);
        speedY = (float) ((-1.0/distance) * diffY);
    }

    private void enemyMove2Players(){
        //distance Player 1
        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));

        //distance player2

        float diffX2 = x - player2.getX() - 8;
        float diffY2 = y - player2.getY() - 8;
        float distance2 = (float) Math.sqrt( (x-player2.getX()) * (x-player2.getX()) + (y-player2.getY()) * (y-player2.getY()));

        // go to playaer 1
        if (distance <= distance2) {

            speedX = (float) ((-1.0/distance) * diffX);
            speedY = (float) ((-1.0/distance) * diffY);

        } else { // else go to player 2

            speedX = (float) ((-1.0/distance2) * diffX2);
            speedY = (float) ((-1.0/distance2) * diffY2);
        }
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

        g.drawImage(Assets.zombie, (int)x,(int)y,width,height,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,width,height);
    }
}
