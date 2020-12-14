package com.company;

import javax.crypto.spec.PBEKeySpec;
import java.util.Random;

public class LevelMenagment {
    private Handler handler;
    private HUD hud;
    private int score = 40;
    private int basicEnemyLen = 4;
    private Random r = new Random();

    public LevelMenagment(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick () {



        if (HUD.score >= score ){


            hud.setLevel(hud.getLevel() + 1);


            if (hud.getLevel() == 2) {
                score += basicEnemyLen*10 + 10;
                System.out.println(score+ "=="+ HUD.score);

                for (int i = 0; i < basicEnemyLen + 1; i ++ ) {
                    handler.addObject(new BasicEnemy(r.nextInt(GameMain.WIDTH-50), r.nextInt(GameMain.HEIGHT-50), ID.BasicEnemy,handler));
                }

                basicEnemyLen += 1;
            }
            else if (hud.getLevel() == 3) {
                score += basicEnemyLen*10 + 10;
                System.out.println(score+ "=="+ HUD.score);

                for (int i = 0; i < basicEnemyLen + 1; i ++ ) {
                    handler.addObject(new BasicEnemy(r.nextInt(GameMain.WIDTH-50), r.nextInt(GameMain.HEIGHT-50), ID.BasicEnemy,handler));
                }

                basicEnemyLen += 1;
            }
            else if (hud.getLevel() == 4) {
                score += basicEnemyLen*10 + 10;

                System.out.println(score+ "=="+ HUD.score);

                for (int i = 0; i < basicEnemyLen + 1; i ++ ) {
                    handler.addObject(new BasicEnemy(r.nextInt(GameMain.WIDTH-50), r.nextInt(GameMain.HEIGHT-50), ID.BasicEnemy,handler));
                }

                basicEnemyLen += 1;
                System.out.println(basicEnemyLen);
            }
            else if (hud.getLevel() == 5){
                score += basicEnemyLen*10 + 30;
                System.out.println("5 levl");
            }



        }


    }
}
