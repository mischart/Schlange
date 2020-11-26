package com.soft.model;

import java.util.List;

public class Game implements GameField {
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

    @Override
    public List<FieldPoint> getSnakeBody() {
        return snake.getBody();
    }

}