package com.company;

import javax.crypto.spec.PBEKeySpec;
import java.util.Random;

public class LevelMenagment {
    private Handler handler;
    private HUD     hud;
    private int     score = 40;
    private int     basicEnemyLen = 0;
    private int     EnemyLen = 4;
    private int     StrongEnemyLen = 0;
    private Random  r = new Random();
    private int     timer;

    public LevelMenagment(Handler handler, HUD hud){
        this.handler = handler;
        this.hud     = hud;
    }

    public void tick () {

        if (HUD.score >= score ) {


            timer++;

            if (timer >= 100) {
                timer = 0;

                hud.setLevel(hud.getLevel() + 1);


                if (hud.getLevel() == 2) {

                    //basicEnemyLen  += 0;
                    EnemyLen += 2;
                    StrongEnemyLen += 1;

                    score += basicEnemyLen * 10 + EnemyLen * 10 + StrongEnemyLen * 10;



                    //Create Enemy
                    for (int i = 0; i < EnemyLen; i++) {
                        handler.addObject(new Enemy(20, r.nextInt(GameMain.HEIGHT - 50),20,32, ID.Enemy, handler));
                    }
                    //Create StrongEnemy
                    for (int i = 0; i < StrongEnemyLen; i++) {
                        handler.addObject(new StrongerEnemy(20, r.nextInt(GameMain.HEIGHT - 50),30,40, ID.StrongerEnemy, handler));
                    }
                    //heal
                    handler.addObject(new Healkit( r.nextInt(GameMain.WIDTH - 50),r.nextInt(GameMain.HEIGHT - 50),20,20 ,ID.Healkit));

                } else if (hud.getLevel() == 3) {


                    //basicEnemyLen += 2;
                    EnemyLen += 4;
                    score += basicEnemyLen * 10 + EnemyLen * 10 + StrongEnemyLen * 10;




                    //Create basicEnemy
                    for (int i = 0; i < basicEnemyLen; i++) {
                        handler.addObject(new BasicEnemy(20, r.nextInt(GameMain.HEIGHT - 50),20,20, ID.BasicEnemy, handler));
                    }
                    //Create Enemy
                    for (int i = 0; i < EnemyLen; i++) {
                        handler.addObject(new Enemy(20, r.nextInt(GameMain.HEIGHT - 50),20,32 , ID.Enemy, handler));
                    }
                    //Create StrongEnemy
                    for (int i = 0; i < StrongEnemyLen; i++) {
                        handler.addObject(new StrongerEnemy(20, r.nextInt(GameMain.HEIGHT - 50),30,40, ID.StrongerEnemy, handler));
                    }

                    //Heal
                    handler.addObject(new Healkit( r.nextInt(GameMain.WIDTH - 50), r.nextInt(GameMain.HEIGHT - 50),20,20 ,ID.Healkit));


                } else if (hud.getLevel() == 4) {


                    //basicEnemyLen += 1;
                    EnemyLen += 3;
                    StrongEnemyLen += 3;
                    score += basicEnemyLen * 10 + EnemyLen * 10 + StrongEnemyLen * 10;



                    //Create basicEnemy
                    for (int i = 0; i < basicEnemyLen; i++) {
                        handler.addObject(new BasicEnemy(20, r.nextInt(GameMain.HEIGHT - 50),20,20, ID.BasicEnemy, handler));
                    }
                    //Create Enemy
                    for (int i = 0; i < EnemyLen; i++) {
                        handler.addObject(new Enemy(20, r.nextInt(GameMain.HEIGHT - 50),20,32, ID.Enemy, handler));
                    }
                    //Create StrongEnemy
                    for (int i = 0; i < StrongEnemyLen; i++) {
                        handler.addObject(new StrongerEnemy(20, r.nextInt(GameMain.HEIGHT - 50),30,40, ID.StrongerEnemy, handler));
                    }

                } else if (hud.getLevel() == 5) {

                    //basicEnemyLen += 1;
                    EnemyLen += 4;
                    StrongEnemyLen += 1;
                    score += basicEnemyLen * 10 + EnemyLen * 10 + StrongEnemyLen * 10;



                    //Create basicEnemy
                    for (int i = 0; i < basicEnemyLen; i++) {
                        handler.addObject(new BasicEnemy(20, r.nextInt(GameMain.HEIGHT - 50),20,20, ID.BasicEnemy, handler));
                    }
                    //Create Enemy
                    for (int i = 0; i < EnemyLen; i++) {
                        handler.addObject(new Enemy(20, r.nextInt(GameMain.HEIGHT - 50),20,32, ID.Enemy, handler));
                    }
                    //Create StrongEnemy
                    for (int i = 0; i < StrongEnemyLen; i++) {
                        handler.addObject(new StrongerEnemy(20, r.nextInt(GameMain.HEIGHT - 50),30,40, ID.StrongerEnemy, handler));
                    }
                } else if (hud.getLevel() == 6) {
                    //basicEnemyLen += 1;
                    EnemyLen += 2;
                    StrongEnemyLen += 1;
                    score += basicEnemyLen * 10 + EnemyLen * 10 + StrongEnemyLen * 10;


                }


            }

        }
    }
}
