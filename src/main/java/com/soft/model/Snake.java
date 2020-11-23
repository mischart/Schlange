package com.soft.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Snake {

    private ObservableList<FieldPoint> body;
    private Direction direction;

    public Snake() {
        init();
    }

    private void init() {
        body = FXCollections.observableArrayList(fieldPoint -> new Observable[]{fieldPoint.xProperty(), fieldPoint.yProperty()});
        direction = Direction.UP;
    }

    public ObservableList<FieldPoint> getBody() {
        return FXCollections.unmodifiableObservableList(body);
    }
}