package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private int neg;

    public KeyInput (Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //super.keyPressed(e);

        int key = e.getKeyCode();

        for (int i = 0; i< handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);



            if (tempObject.getId() == ID.Player){
                //key events fo player 1


                if (key == KeyEvent.VK_A) tempObject.setSpeedX(-5);
                if (key == KeyEvent.VK_D) tempObject.setSpeedX(5);
                if (key == KeyEvent.VK_W) tempObject.setSpeedY(-5);
                if (key == KeyEvent.VK_S) tempObject.setSpeedY(5);

                if (key == KeyEvent.VK_SPACE) tempObject.setShooting(true);



            }

            if (tempObject.getId() == ID.Player2){
                //key events fo player 1

                if (key == KeyEvent.VK_UP) tempObject.setSpeedY(-5);
                if (key == KeyEvent.VK_LEFT) tempObject.setSpeedX(-5);
                if (key == KeyEvent.VK_RIGHT) tempObject.setSpeedX(5);
                if (key == KeyEvent.VK_DOWN) tempObject.setSpeedY(5);

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //super.keyReleased(e);
        int key = e.getKeyCode();

        for (int i = 0; i< handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if ( tempObject.getId() == ID.Player){
                //key events fo player 1

                if (key == KeyEvent.VK_W) tempObject.setSpeedY(0);
                if (key == KeyEvent.VK_S) tempObject.setSpeedY(0);
                if (key == KeyEvent.VK_A) tempObject.setSpeedX(0);
                if (key == KeyEvent.VK_D) tempObject.setSpeedX(0);

                if (key == KeyEvent.VK_SPACE) tempObject.setShooting(false);


            }


            if (tempObject.getId() == ID.Player2){
                //key events fo player 1

                if (key == KeyEvent.VK_UP) tempObject.setSpeedY(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setSpeedX(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setSpeedX(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setSpeedY(0);

            }
        }


    }
}
