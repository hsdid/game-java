package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class GameMain extends Canvas implements Runnable {

    public static final int WIDTH = 850, HEIGHT = 550;
    private boolean         running = false;
    private Handler         handler;
    private Random          r;
    private HUD hud;

    public GameMain() {

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        hud = new HUD();

        new Window(WIDTH,HEIGHT,"RECTANGLE FOOTBALL", this);

        r = new Random();

        for (int i = 0; i <= 5; i ++ )
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy,handler));

        handler.addObject(new Playyer(WIDTH/2 - 32,HEIGHT/2 -32,ID.Player, handler));


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

        this.requestFocus();
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
        hud.tick();
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

        hud.render(g);

        g.dispose();
        bs.show();
    }


    public static void main(String[] args) {

        new GameMain();

    }


}
