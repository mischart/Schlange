package com.soft.model;

public class FieldPoint {

    private int x;
    private int y;

    public FieldPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    void move(int xToMove, int yToMove) {
        x += xToMove;
        y += yToMove;
    }

    boolean equalsLocation(FieldPoint point) {
        return x == point.x && y == point.y;
    }

}
