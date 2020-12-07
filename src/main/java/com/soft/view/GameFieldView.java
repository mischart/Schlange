package com.soft.view;

import com.soft.viewmodel.GameFieldViewModel;
import com.soft.viewmodel.ViewModelPoint;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class GameFieldView extends View implements Initializable {

    private final GameFieldViewModel viewModel;
    private int gameObjectWidth;
    private int gameObjectHeight;
    private ObservableList<GameObject> snakeGameObjects;
    private AnimationTimer timer;
    private long animationSpeed;
    private static final String POINTS = "points";
    @FXML
    private VBox root;
    @FXML
    private Pane gameFieldPane;
    @FXML
    private Label scoreLabel;

    public GameFieldView(GameFieldViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setGameFieldSize(int gameFieldWidth, int gameFieldHeight) {
        gameFieldPane.setPrefSize(gameFieldWidth, gameFieldHeight);
    }

    public void setGameObjectSize(int gameObjectWidth, int gameObjectHeight) {
        this.gameObjectWidth = gameObjectWidth;
        this.gameObjectHeight = gameObjectHeight;
    }

    @Override
    public Pane getRoot() {
        return root;
    }

    @Override
    public ViewType getViewType() {
        return ViewType.GAME_FIELD;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String pointString = resources.getString(POINTS);
        scoreLabel.textProperty().bind(new SimpleStringProperty(pointString).concat(viewModel.scoreProperty().asString()));
        GameObject foodGameObject = createGameObject(viewModel.getFood(), Color.RED);
        gameFieldPane.getChildren().add(foodGameObject);
        snakeGameObjects = FXCollections.observableArrayList();
        ListChangeListener<GameObject> gameObjectListListener = createGameObjectListListener();
        snakeGameObjects.addListener(gameObjectListListener);
        ListChangeListener<ViewModelPoint> snakeListener = createSnakeListener();
        viewModel.getSnakeBody().addListener(snakeListener);
        timer = createAnimationTimer();
        timer.start();
        animationSpeed = 1000000000 / 8;
        viewModel.gameOverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            }
        });
    }

    private ListChangeListener<ViewModelPoint> createSnakeListener() {
        return change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    change.getAddedSubList().forEach(viewModelPoint -> snakeGameObjects.add(createGameObject(viewModelPoint, Color.BLACK)));
                }
                if (change.wasRemoved()) {
                    change.getRemoved().forEach(point -> snakeGameObjects.removeIf(item -> item.getIndex() == point.getIndex()));
                }

            }
        };
    }

    private ListChangeListener<GameObject> createGameObjectListListener() {
        return change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    gameFieldPane.getChildren().addAll(change.getAddedSubList());
                }
                if (change.wasRemoved()) {
                    gameFieldPane.getChildren().removeAll(change.getRemoved());
                }
            }
        };
    }

    @Override
    void keyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                viewModel.moveUp();
                break;
            case DOWN:
                viewModel.moveDown();
                break;
            case LEFT:
                viewModel.moveLeft();
                break;
            case RIGHT:
                viewModel.moveRight();
                break;
        }
    }

    private GameObject createGameObject(ViewModelPoint viewModelPoint, Color color) {
        GameObject rectangle = new GameObject(gameObjectWidth, gameObjectHeight, color, viewModelPoint.getIndex());
        rectangle.xProperty().bind(viewModelPoint.xProperty().multiply(gameObjectWidth));
        rectangle.yProperty().bind(viewModelPoint.yProperty().multiply(gameObjectHeight));
        return rectangle;
    }

    private AnimationTimer createAnimationTimer() {
        return new AnimationTimer() {

            private long lastTime = 0;

            @Override
            public void handle(long now) {
                if (now - lastTime > animationSpeed) {
                    lastTime = now;
                    viewModel.update();
                }
            }
        };
    }

}