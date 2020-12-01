package com.soft.model;

import java.util.List;
import java.util.Random;

public class Game implements GameField {

    private final int fieldWidth;
    private final int fieldHeight;
    private Snake snake;
    private final FieldPoint food;
    private final Random random;

    public Game(int fieldWidth, int fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        food = new FieldPoint(0, 0);
        random = new Random();
    }

    @Override
    public void reset() {
        snake = new Snake(fieldWidth / 2, fieldHeight / 2);
        showFood();
    }

    @Override
    public List<FieldPoint> getSnakeBody() {
        return snake.getBody();
    }

    @Override
    public FieldPoint getFood() {
        return food;
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

    private void showFood() {
        int randomX;
        int randomY;
        start:
        while (true) {
            randomX = random.nextInt(fieldWidth);
            randomY = random.nextInt(fieldHeight);
            for (FieldPoint point : getSnakeBody()) {
                if (point.getX() == randomX && point.getY() == randomY) {
                    continue start;
                }
            }
            break;
        }
        food.setX(randomX);
        food.setY(randomY);
    }

    private boolean isSnakeOutside() {
        return snake.getHead().getX() < 0 || snake.getHead().getX() > fieldWidth
                || snake.getHead().getY() < 0 || snake.getHead().getY() > fieldHeight;
    }

}