package com.soft.view;

import javafx.stage.Stage;

import java.util.EnumMap;

public class StageController implements ViewSwitch {
    private final Stage stage;
    private final EnumMap<ViewType, View> viewEnumMap;
    private ViewType activeView;

    public StageController(Stage stage) {
        this.stage = stage;
        this.viewEnumMap = new EnumMap<>(ViewType.class);
        stage.getScene().setOnKeyPressed(e -> viewEnumMap.get(activeView).keyPressed(e.getCode()));
    }

    public void addView(View view) {
        viewEnumMap.put(view.getViewType(), view);
        view.setViewSwitch(this);
    }

    @Override
    public void activateView(ViewType viewType) {
        activeView = viewType;
        stage.getScene().setRoot(viewEnumMap.get(viewType).getRoot());
        stage.sizeToScene();
    }

}
