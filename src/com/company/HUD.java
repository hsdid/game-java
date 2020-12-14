package com.company;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;
    public static int score = 0;
    private int level = 1;


    public void tick() {


    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);
        g.setColor(Color.green);
        g.fillRect(15,15, HEALTH *2, 32);

        g.setColor(Color.white);
        g.drawString("Score: " + score, 15, 68);
        g.drawString("Level: " + level, 15, 80);

    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
