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

    void update() {
        updateRest();
        updateHead();
    }

    private void updateHead() {
        switch (direction) {
            case UP:
                body.get(0).moveUp();
                break;
            case DOWN:
                body.get(0).moveDown();
                break;
            case RIGHT:
                body.get(0).moveRight();
                break;
            case LEFT:
                body.get(0).moveLeft();
                break;
        }
    }

    private void updateRest() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setX(body.get(i - 1).getX());
            body.get(i).setY(body.get(i - 1).getY());
        }
    }

}