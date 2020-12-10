package com.soft.view;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public abstract class View {

    ViewSwitch viewSwitch;

    abstract Pane getRoot();

    abstract ViewType getViewType();

    abstract void keyPressed(KeyCode keyCode);

    public void setViewSwitch(ViewSwitch viewSwitch) {
        this.viewSwitch = viewSwitch;
    }
}
