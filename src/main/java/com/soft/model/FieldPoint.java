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

    void moveUp() {
        move(0, -1);
    }

    void moveDown() {
        move(0, 1);
    }

    void moveRight() {
        move(1, 0);
    }

    void moveLeft() {
        move(-1, 0);
    }

    private void move(int xToMove, int yToMove) {
        x += xToMove;
        y += yToMove;
    }

}
