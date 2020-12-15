package com.company;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage zombie,zombie2,player,ground,playerRight;
    private static  final int width = 10, height = 18;
    private static  final int width2 = 16, height2 = 23;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/zombie.png"));
        zombie = sheet.crop(11,7,width,height);

        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/zombie2.png"));
        zombie2 = sheet2.crop(40,5,width2,height2);

        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
        player      = sheet1.crop(11,7,width,height);
        playerRight = sheet1.crop(42,7,width,height);

        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/tile.png"));
        ground = sheet3.crop(0,0,185,185);
    }
}
