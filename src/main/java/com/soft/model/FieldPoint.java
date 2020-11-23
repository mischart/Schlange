package com.soft.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class FieldPoint {
    private final IntegerProperty x;
    private final IntegerProperty y;

    public FieldPoint(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public ReadOnlyIntegerProperty xProperty() {
        return x;
    }

    public ReadOnlyIntegerProperty yProperty() {
        return y;
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }
}
