package com.company;

import java.awt.*;


public abstract class GameObject {

    protected float     x, y;
    protected ID        id;
    protected float     speedX, speedY;
    protected boolean   shooting = false;
    //values: 1-left, 2-right, 3-up, 4-down
    protected int       direction;

    public GameObject(float x, float y, ID id) {
        this.x  = x;
        this.y  = y;
        this.id = id;

    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

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

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isShooting() {
        return shooting;
    }

    public int getDirection() {
        return direction;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public ID getId() {
        return id;
    }


}
