package com.soft.viewmodel;

import com.soft.model.GameStart;

public class GameStartViewModel {
    private GameStart model;

    public GameStartViewModel(GameStart model) {
        this.model = model;
    }

    public void startGame() {
        model.reset();
    }

}