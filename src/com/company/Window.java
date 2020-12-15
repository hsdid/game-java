package com.company;

import javax.swing.*;
import java.awt.*;

public class Window  extends Canvas {

    public Window(int width, int height, String title, GameMain game){

        JFrame frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();

    }
}
