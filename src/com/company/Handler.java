package com.company;

import java.awt.*;
import java.util.LinkedList;

// loop each whole objects in game and render, update then to screen
public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for (int i = 0; i < object.size(); i++){
            // Get Object and updates
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }
    public void render (Graphics g) {
        for (int i = 0; i < object.size(); i++){
            // Get Object and render
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }

    }


    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove();
    }

}
