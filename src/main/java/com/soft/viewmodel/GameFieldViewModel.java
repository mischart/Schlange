package com.soft.viewmodel;

import com.soft.model.GameField;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameFieldViewModel {
    private final GameField model;
    private final ObservableList<ViewModelPoint> snakeBody;
    private final ViewModelPoint food;
    private final BooleanProperty gameOver;
    private final IntegerProperty score;

    public GameFieldViewModel(GameField gameField) {
        this.model = gameField;
        snakeBody = FXCollections.observableArrayList();
        food = new ViewModelPoint(0, 0);
        gameOver = new SimpleBooleanProperty(false);
        score = new SimpleIntegerProperty(0);
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

    public ReadOnlyIntegerProperty scoreProperty() {
        return score;
    }

    public void update() {
        model.update();
        updateSnakeBody();
        updateFood();
        updateScore();
        if (model.isGameOver()) {
            gameOver.set(true);
            reset();
        }
    }

    private void reset() {
        score.set(0);
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

    private void updateScore() {
        score.set(model.getScore());
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
