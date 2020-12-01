package com.soft.model;

import java.util.List;

public interface GameField {

    List<FieldPoint> getSnakeBody();

    void update();

    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    boolean isGameOver();

    void reset();

}
