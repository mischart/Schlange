package com.soft.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {

    private List<FieldPoint> body;
    private Direction direction;

    public Snake(int startX, int startY) {
        init(startX, startY);
    }

    private void init(int startX, int startY) {
        body = new ArrayList<>();
        direction = Direction.UP;
        body.addAll(Arrays.asList(new FieldPoint(startX, startY), new FieldPoint(startX, startY + 1)));
    }

    public List<FieldPoint> getBody() {
        return new ArrayList<>(body);
    }

    FieldPoint getHead() {
        return body.get(0);
    }

    void update() {
        updateRest();
        updateHead();
    }

    private void updateHead() {
        switch (direction) {
            case UP:
                getHead().move(0, -1);
                break;
            case DOWN:
                getHead().move(0, 1);
                break;
            case RIGHT:
                getHead().move(1, 0);
                break;
            case LEFT:
                getHead().move(-1, 0);
                break;
        }
    }

    private void updateRest() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setX(body.get(i - 1).getX());
            body.get(i).setY(body.get(i - 1).getY());
        }
    }

    boolean hasPoint(FieldPoint point) {
        for (FieldPoint snakePoint : body) {
            if (snakePoint.getX() == point.getX() && snakePoint.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    void extend() {
        FieldPoint tail = body.get(body.size() - 1);
        body.add(new FieldPoint(tail.getX(), tail.getY()));
    }

    void up() {
        if (!direction.equals(Direction.DOWN))
            direction = Direction.UP;
    }

    void down() {
        if (!direction.equals(Direction.UP))
            direction = Direction.DOWN;
    }

    void left() {
        if (!direction.equals(Direction.RIGHT))
            direction = Direction.LEFT;
    }

    void right() {
        if (!direction.equals(Direction.LEFT))
            direction = Direction.RIGHT;
    }

}