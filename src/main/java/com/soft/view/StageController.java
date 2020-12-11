package com.soft.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.EnumMap;

import static com.soft.view.ViewType.GAME_START;

public class StageController implements ViewSwitch {
    private Stage stage;
    private final EnumMap<ViewType, View> viewEnumMap;
    private ViewType activeView;

    public StageController(Stage stage) {
        this.stage = stage;
        this.viewEnumMap = new EnumMap<>(ViewType.class);
    }

    public void addView(View view) {
        viewEnumMap.put(view.getViewType(), view);
        view.setViewSwitch(this);
    }

    public void start() {
        Scene scene = new Scene(viewEnumMap.get(GAME_START).getRoot());
        activeView = GAME_START;
        scene.setOnKeyPressed(e -> viewEnumMap.get(activeView).keyPressed(e.getCode()));
        stage.setScene(scene);
    }

    @Override
    public void activateView(ViewType viewType) {
        activeView = viewType;
        stage.getScene().setRoot(viewEnumMap.get(viewType).getRoot());
        stage.sizeToScene();
        viewEnumMap.get(viewType).activated();
    }

}
