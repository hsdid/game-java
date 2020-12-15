package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private GameMain game;
    private Button   playBtn;
    private Button   quitBtn;
    private Button   twoPlayers;
    private Handler  handler;
    private Random   r = new Random();

    public Menu(GameMain game, Handler handler){

        this.game    = game;
        this.handler = handler;
        playBtn      = new Button((GameMain.WIDTH/2)-150,100,300,64, "play");
        twoPlayers   = new Button((GameMain.WIDTH/2)-150,200,300,64, "2 palyers");
        quitBtn      = new Button((GameMain.WIDTH/2)-150,300,300,64, "Quit");


    }

    public void mousePressed(MouseEvent e) {
        int mx      = e.getX();
        int my      = e.getY();

        if (playBtn.mouseOver(mx,my)){

            game.gameState = GameMain.STATE.Game;

            handler.addObject(new Playyer(game.WIDTH/2 - 32,game.HEIGHT/2 -32,ID.Player, handler));

            for (int i = 0; i < 4; i ++ )
                    handler.addObject(new Enemy(20, r.nextInt(GameMain.HEIGHT-50), ID.Enemy,handler));

        }
        else if (twoPlayers.mouseOver(mx,my)) {

            game.gameState = GameMain.STATE.Game;

            handler.addObject(new Playyer(game.WIDTH/2 - 32,game.HEIGHT/2 -32,ID.Player, handler));
            handler.addObject(new Playyer(game.WIDTH/2 - 32,game.HEIGHT/2 -32,ID.Player2, handler));

            for (int i = 0; i < 4; i ++ )
                handler.addObject(new Enemy(20, r.nextInt(GameMain.HEIGHT-50), ID.Enemy,handler));

        }
        else if (quitBtn.mouseOver(mx,my)) {
           System.exit(1);

        }

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void tick() {

    }


    public void render(Graphics g){

        Font fnt = new Font("arial",1,50);
        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("Menu", (GameMain.WIDTH/2)-50,70);

        playBtn.render(g);
        twoPlayers.render(g);
        quitBtn.render(g);
        g.drawImage(Assets.zombie, 100,100,80,120,null);

    }
}
