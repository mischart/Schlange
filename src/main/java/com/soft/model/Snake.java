package com.soft.model;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<FieldPoint> body;
    private Direction direction;

    public Snake() {
        init();
    }

    private void init() {
        body = new ArrayList<>();
        direction = Direction.UP;
    }

    public List<FieldPoint> getBody() {
        return new ArrayList<>(body);
    }
}