package com.soft.model;

import java.util.List;
import java.util.Random;

public class Game implements GameField {

    private final int fieldWidth;
    private final int fieldHeight;
    private final FieldPoint food;
    private final Random random;
    private Snake snake;

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
        if (isFoodEaten()) {
            snake.extend();
            showFood();
        }
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
        return isSnakeOutside() || isSnakeDestroyed();
    }

    private void showFood() {
        int randomX;
        int randomY;
        while (true) {
            randomX = random.nextInt(fieldWidth);
            randomY = random.nextInt(fieldHeight);
            if (snake.hasPoint(new FieldPoint(randomX, randomY)))
                continue;
            break;
        }
        food.setX(randomX);
        food.setY(randomY);
    }

    private boolean isFoodEaten() {
        return snake.getHead().equalsLocation(food);
    }

    private boolean isSnakeDestroyed() {
        FieldPoint head = snake.getHead();
        return getSnakeBody().stream().anyMatch(point -> !head.equals(point) && head.equalsLocation(point));
    }

    private boolean isSnakeOutside() {
        return snake.getHead().getX() < 0 || snake.getHead().getX() > fieldWidth
                || snake.getHead().getY() < 0 || snake.getHead().getY() > fieldHeight;
    }

}