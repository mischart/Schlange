package com.soft.viewmodel;

import com.soft.model.GameField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameFieldViewModel {
    private final GameField gameField;
    private final ObservableList<ViewModelPoint> snakeBody;

    public GameFieldViewModel(GameField gameField) {
        this.gameField = gameField;
        snakeBody = FXCollections.observableArrayList();
        gameField.getSnakeBody().forEach(fieldPoint -> snakeBody.add(new ViewModelPoint(fieldPoint.getX(), fieldPoint.getY())));
    }

    public ObservableList<ViewModelPoint> getSnakeBody() {
        return FXCollections.unmodifiableObservableList(snakeBody);
    }
}
