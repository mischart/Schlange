package com.soft.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ViewModelPoint {
    private final IntegerProperty x;
    private final IntegerProperty y;

    public ViewModelPoint(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public ReadOnlyIntegerProperty xProperty() {
        return x;
    }

    protected void setX(int x) {
        this.x.set(x);
    }

    public ReadOnlyIntegerProperty yProperty() {
        return y;
    }

    protected void setY(int y) {
        this.y.set(y);
    }
}
