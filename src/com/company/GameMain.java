package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class GameMain extends Canvas  {

    public static final int WIDTH = 700, HEIGHT = 550;
    private boolean         running = false;
    private Handler         handler;
    private Random          r;
    private HUD             hud;
    private LevelMenagment  levelMen;
    private Menu            menu;
    private int tilex = 40 , tiley = 40;

    public enum STATE {
        Menu,
        Game
    }

    public STATE gameState = STATE.Menu;

    public GameMain() {

        handler  = new Handler();
        menu     = new Menu(this,handler);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        new Window(WIDTH,HEIGHT,"", this);

        hud      = new HUD(this,handler);
        levelMen = new LevelMenagment(handler, hud);
        r        = new Random();

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
        long lastTime        = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns            = 1000000000 / amountOfTicks;
        double delta         = 0;
        long timer           = System.currentTimeMillis();
        int frames           = 0;

        Assets.init();

        while(running){

            long now = System.nanoTime();

            delta   += (now - lastTime) / ns;
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


    private void tick() {

        handler.tick();

        if (gameState == STATE.Game) {
            hud.tick();
            levelMen.tick();
        }
        else if (gameState == STATE.Menu){
            menu.tick();
        }
    }

    public void drawbackground(Graphics g) {
        for (int i = 0; i <= 25; i ++ ){
            for (int j = 0; j <= 12; j ++ ) {
                g.drawImage(Assets.ground, i*tilex,j*tiley, tilex,tiley,null);
            }
        }
    }

    private void render(){

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // render background
        drawbackground(g);

        handler.render(g);



        if (gameState == STATE.Game) {
            hud.render(g);

        }
        else if (gameState == STATE.Menu){

            menu.render(g);

        }

        g.dispose();
        bs.show();
    }


    public static void main(String[] args) {

        new GameMain();

    }


}
