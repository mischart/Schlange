package com.soft.view;

import com.soft.viewmodel.GameFieldViewModel;
import com.soft.viewmodel.ViewModelPoint;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class GameFieldView extends View implements Initializable {

    private final GameFieldViewModel viewModel;
    private int gameObjectWidth;
    private int gameObjectHeight;
    private ObservableList<Rectangle> snakeBody;

    @FXML
    private Pane gameFieldRoot;
    private final ListChangeListener<Rectangle> gameObjectListListener = change -> {
        while (change.next()) {
            if (change.wasAdded()) {
                gameFieldRoot.getChildren().addAll(change.getAddedSubList());
            }
            if (change.wasRemoved()) {
                gameFieldRoot.getChildren().removeAll(change.getRemoved());
            }
        }
    };

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        snakeBody = FXCollections.observableArrayList();
        snakeBody.addListener(gameObjectListListener);
        viewModel.getSnakeBody().forEach(viewModelPoint -> snakeBody.add(createGameObject(viewModelPoint, Color.BLACK)));
    }

    private Rectangle createGameObject(ViewModelPoint viewModelPoint, Color color) {
        Rectangle rectangle = new Rectangle(gameObjectWidth, gameObjectHeight, color);
        rectangle.xProperty().bind(viewModelPoint.xProperty().multiply(gameObjectWidth));
        rectangle.yProperty().bind(viewModelPoint.yProperty().multiply(gameObjectHeight));
        return rectangle;
    }

}