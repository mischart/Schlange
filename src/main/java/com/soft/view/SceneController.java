package com.soft.view;

import javafx.scene.Scene;

import java.util.EnumMap;

public class SceneController {
    private final EnumMap<ViewType, View> viewEnumMap;
    private final Scene scene;

    public SceneController(EnumMap<ViewType, View> viewEnumMap, Scene scene) {
        this.viewEnumMap = viewEnumMap;
        this.scene = scene;
    }
}
