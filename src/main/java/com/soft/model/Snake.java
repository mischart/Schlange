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
}