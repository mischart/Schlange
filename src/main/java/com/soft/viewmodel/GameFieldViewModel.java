package com.soft.viewmodel;

import com.soft.model.GameField;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameFieldViewModel {
    private final GameField model;
    private final ObservableList<ViewModelPoint> snakeBody;
    private final ViewModelPoint food;
    private final BooleanProperty gameOver;

    public GameFieldViewModel(GameField gameField) {
        this.model = gameField;
        snakeBody = FXCollections.observableArrayList();
        food = new ViewModelPoint(0, 0);
        gameOver = new SimpleBooleanProperty(false);
        reset();
    }

    public ObservableList<ViewModelPoint> getSnakeBody() {
        return FXCollections.unmodifiableObservableList(snakeBody);
    }

    public ViewModelPoint getFood() {
        return food;
    }

    public ReadOnlyBooleanProperty gameOverProperty() {
        return gameOver;
    }

    public void update() {
        model.update();
        updateSnakeBody();
        updateFood();
        if (model.isGameOver()) {
            gameOver.set(true);
            reset();
        }
    }

    private void reset() {
        gameOver.set(false);
        snakeBody.clear();
        model.reset();
    }

    private void updateSnakeBody() {
        for (int i = 0; i < model.getSnakeBody().size(); i++) {
            if (snakeBody.size() < model.getSnakeBody().size()) {
                snakeBody.add(new ViewModelPoint());
            }
            snakeBody.get(i).setX(model.getSnakeBody().get(i).getX());
            snakeBody.get(i).setY(model.getSnakeBody().get(i).getY());
            snakeBody.get(i).setIndex(i);
        }
    }

    private void updateFood() {
        food.setX(model.getFood().getX());
        food.setY(model.getFood().getY());
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
