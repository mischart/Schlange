package com.soft.viewmodel;

import com.soft.model.GameField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameFieldViewModel {
    private final GameField model;
    private final ObservableList<ViewModelPoint> snakeBody;

    public GameFieldViewModel(GameField gameField) {
        this.model = gameField;
        snakeBody = FXCollections.observableArrayList();
        gameField.getSnakeBody().forEach(fieldPoint -> snakeBody.add(new ViewModelPoint(fieldPoint.getX(), fieldPoint.getY())));
    }

    public ObservableList<ViewModelPoint> getSnakeBody() {
        return FXCollections.unmodifiableObservableList(snakeBody);
    }

    public void update() {
        model.update();
        updateSnakeBody();
    }

    private void updateSnakeBody() {
        for (int i = 0; i < model.getSnakeBody().size(); i++) {
            snakeBody.get(i).setX(model.getSnakeBody().get(i).getX());
            snakeBody.get(i).setY(model.getSnakeBody().get(i).getY());
        }
    }

    public void moveUp() {
        model.moveUp();
    }

    public void moveDown() {
        model.moveDown();
    }

    public void moveLeft() {
        model.moveLeft();
    }

    public void moveRight() {
        model.moveRight();
    }

}
