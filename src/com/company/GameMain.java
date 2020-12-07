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
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));


        new Window(WIDTH,HEIGHT,"RECTANGLE FOOTBALL", this);

        for (int i= 0; i < 50; i++)

        handler.addObject(new Playyer(100,100,ID.Player));
        handler.addObject(new Playyer(100,100,ID.Player2));

        this.run();
    }

    public void start(){
        running = true;
    }
    public void stop(){
        running = false;
    }

    // main loop
    public void run() {


        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running){
            long now = System.nanoTime();

            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running) {
                render();
            }
            frames ++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("Fps: "+ frames);
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
