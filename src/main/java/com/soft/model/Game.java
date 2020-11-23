package com.soft.model;

import javafx.collections.ObservableList;

public class Game {
    private final int fieldWidth;
    private final int fieldHeight;
    private Snake snake;

    public Game(int fieldWidth, int fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        init();
    }

    private void init() {
        snake = new Snake();
    }

    public ObservableList<FieldPoint> getSnakeBody() {
        return snake.getBody();
    }

}