package com.company;

import java.awt.*;

public class StrongerEnemy extends GameObject{


    private int         health;
    Handler             handler;
    private GameObject  player;
    private GameObject  player2;
    private float       distance;
    private float       distance2;

    int                 timer = 40;
    int                 wight = 30,height=40;


    public StrongerEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
        this.health  = 10;
        //get player rom object list
        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player)
                player = handler.object.get(i);

            if (handler.object.get(i).getId() == ID.Player2) {
                player2 = handler.object.get(i);
            }
        }
    }


    public void tick() {

        x += speedX;
        y += speedY;

        moveEnemy();

        if (y <= 0 || y >= GameMain.HEIGHT - 32) speedY *= -1;
        if (x <= 0 || x >= GameMain.WIDTH - 32) speedX *= -1;

        collision();

        shoot();
    }

    public void shoot() {
        if (player2 == null) {

            distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));

            if (distance <= 150) {

                timer ++;

                speedX = 0;
                speedY = 0;

                if (timer >= 50){

                    float diffX = x - player.getX() - 8;
                    float diffY = y - player.getY() - 8;

                    float toX = (float) ((-1.0/distance) * diffX);
                    float toY = (float) ((-1.0/distance) * diffY);

                    handler.addObject(new EnemyBullet(x, y, ID.EnemyBullet, handler,toX,toY));
                    timer = 0;
                }
            }
        }
        else {

            distance  = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY())); // distance from player1
            distance2 = (float) Math.sqrt( (x-player2.getX()) * (x-player2.getX()) + (y-player2.getY()) * (y-player2.getY())); // distance from player2

                    //if true shoot to player 1
                    if (distance <= distance2 && distance <= 150){

                        timer ++;
                        speedX = 0;
                        speedY = 0;

                        if (timer >= 50){

                            float diffX = x - player.getX() - 8;
                            float diffY = y - player.getY() - 8;


                            float toX = (float) ((-1.0/distance) * diffX);
                            float toY = (float) ((-1.0/distance) * diffY);

                            handler.addObject(new EnemyBullet(x, y, ID.EnemyBullet, handler,toX,toY));
                            timer = 0;

                        }
                    }
                    else if (distance >= distance2 && distance2 <= 150){

                        timer ++;
                        speedX = 0;
                        speedY = 0;
                        if (timer >= 50) {
                            //shoot to player 2
                            float diffX = x - player2.getX() - 8;
                            float diffY = y - player2.getY() - 8;


                            float toX = (float) ((-1.0 / distance2) * diffX);
                            float toY = (float) ((-1.0 / distance2) * diffY);

                            handler.addObject(new EnemyBullet(x, y, ID.EnemyBullet, handler, toX, toY));
                            timer = 0;
                        }
                    }
                }
        }



    private void moveEnemy() {
        if ( player2 == null ){

            enemyMoveOnePlayer();

        } else {
            enemyMove2Players();

        }
    }

    private void enemyMoveOnePlayer(){

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;

        distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));

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
        distance2 = (float) Math.sqrt( (x-player2.getX()) * (x-player2.getX()) + (y-player2.getY()) * (y-player2.getY()));

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
        }
    }


    public void render(Graphics g) {
       // g.setColor(Color.red);
        //g.fillRect((int)x,(int)y,20, 32);
        g.drawImage(Assets.zombie2, (int)x,(int)y,wight,height,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,wight,height);
    }
}
