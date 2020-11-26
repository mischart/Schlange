package com.soft.model;

public class FieldPoint {
    private int x;
    private int y;

    public FieldPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected void setY(int y) {
        this.y = y;
    }
}
