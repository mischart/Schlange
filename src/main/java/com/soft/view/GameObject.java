package com.soft.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameObject extends Rectangle {

    private final int index;

    public GameObject(int width, int height, Color color, int index) {
        super(width, height, color);
        this.index = index;
    }

    int getIndex() {
        return index;
    }
}
