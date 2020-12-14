package com.company;

import java.awt.*;
import java.security.PublicKey;

public class Button {

    private int     x;
    private int     y;
    private int     width;
    private int     height;
    private String  name;

    public Button (int x, int y, int width, int height, String name) {

        this.x      = x;
        this.y      = y;
        this.width  = width;
        this.height = height;
        this.name   = name;

    }

    public void render(Graphics g){

        Font fnt = new Font("arial",1,30);
        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString(name,x+(width/2)-15,y + height/2);

        g.setColor(Color.WHITE);
        g.drawRect(x,y,width,height);

    }

    public boolean mouseOver(int mx, int my){
        if (mx > x && mx < x + width) {
            if (my > y && my < y +height) {
                return true;
            }else return false;
        } else return false;
    }
}
