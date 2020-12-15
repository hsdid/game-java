package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private int neg;

    public KeyInput (Handler handler) {
        this.handler = handler;
    }


    public void keyPressed(KeyEvent e) {


        int key = e.getKeyCode();

        for (int i = 0; i< handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);



            if (tempObject.getId() == ID.Player){
                //key events fo player 1


                if (key == KeyEvent.VK_A) {

                    tempObject.direction = 1;
                    tempObject.setSpeedX(-5);
                }
                if (key == KeyEvent.VK_D) {


                    tempObject.direction = 2;
                    tempObject.setSpeedX(5);
                }
                if (key == KeyEvent.VK_W) {


                    tempObject.direction = 3;
                    tempObject.setSpeedY(-5);
                }
                if (key == KeyEvent.VK_S) {


                    tempObject.direction = 4;
                    tempObject.setSpeedY(5);
                }

                if (key == KeyEvent.VK_SPACE) tempObject.setShooting(true);

            }
        }
    }

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

        }


    }
}
