package com.soft.view;

import com.soft.viewmodel.GameFieldViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class GameFieldView extends View {

    private final GameFieldViewModel viewModel;
    private int gameObjectWidth;
    private int gameObjectHeight;

    @FXML
    private Pane gameFieldRoot;

    public GameFieldView(GameFieldViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setGameFieldSize(int gameFieldWidth, int gameFieldHeight) {
        gameFieldRoot.setPrefSize(gameFieldWidth, gameFieldHeight);
    }

    public void setGameObjectSize(int gameObjectWidth, int gameObjectHeight) {
        this.gameObjectWidth = gameObjectWidth;
        this.gameObjectHeight = gameObjectHeight;
    }

    @Override
    public Pane getRoot() {
        return gameFieldRoot;
    }

    @Override
    public ViewType getViewType() {
        return ViewType.GAME_FIELD;
    }

}