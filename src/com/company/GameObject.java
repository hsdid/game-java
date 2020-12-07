package com.company;

import java.awt.*;

//for example player, ennemys is Gameobject
public abstract class GameObject {

    protected int x, y;
    protected ID  id;
    protected int speedX, speedY;

    public GameObject(int x, int y, ID id) {
        this.x  = x;
        this.y  = y;
        this.id = id;

    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public ID getId() {
        return id;
    }
}
