package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class GameMain extends Canvas implements Runnable {

    public static final int WIDTH = 850, HEIGHT = 550;
    private boolean         running = false;
    private Handler         handler;

    public GameMain() {
        new Window(WIDTH,HEIGHT,"RECTANGLE FOOTBALL", this);
        handler = new Handler();
    }

    public void start(){
        running = true;
    }
    public void stop(){
        running = false;
    }
    // main loop
    public void run() {

        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running){
            if (running) {
                render();
            }
            frames ++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("Fps: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    //updates
    private void tick() {
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }




    public static void main(String[] args) {

        new GameMain();
    }


}
