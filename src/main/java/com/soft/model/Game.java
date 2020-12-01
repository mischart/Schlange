package com.soft.model;

import java.util.List;

public class Game implements GameField {

    private final int fieldWidth;
    private final int fieldHeight;
    private Snake snake;

    public Game(int fieldWidth, int fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
    }

    @Override
    public void reset() {
        snake = new Snake(fieldWidth / 2, fieldHeight / 2);
    }

    @Override
    public List<FieldPoint> getSnakeBody() {
        return snake.getBody();
    }

    @Override
    public void update() {
        snake.update();
    }

    @Override
    public void moveUp() {
        snake.up();
    }

    @Override
    public void moveDown() {
        snake.down();
    }

    @Override
    public void moveLeft() {
        snake.left();
    }

    @Override
    public void moveRight() {
        snake.right();
    }

    @Override
    public boolean isGameOver() {
        return isSnakeOutside();
    }

    private boolean isSnakeOutside() {
        return snake.getHead().getX() < 0 || snake.getHead().getX() > fieldWidth
                || snake.getHead().getY() < 0 || snake.getHead().getY() > fieldHeight;
    }

}