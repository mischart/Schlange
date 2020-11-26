package com.soft.view;

import javafx.scene.Scene;

import java.util.EnumMap;

public class SceneController implements ViewSwitch {
    private final Scene scene;
    private final EnumMap<ViewType, View> viewEnumMap;

    public SceneController(Scene scene) {
        this.scene = scene;
        this.viewEnumMap = new EnumMap<>(ViewType.class);
    }

    public void addView(View view) {
        viewEnumMap.put(view.getViewType(), view);
    }

    @Override
    public void activateView(ViewType viewType) {
        scene.setRoot(viewEnumMap.get(viewType).getRoot());
    }
}
