package com.soft.view;

import com.soft.viewmodel.GameStartViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameStartView extends View implements Initializable {

    private final GameStartViewModel viewModel;

    @FXML
    private VBox startRoot;

    @FXML
    private Label gameNameLabel;

    @FXML
    private Button playButton;

    public GameStartView(GameStartViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playButton.setOnAction(this::playButtonClicked);
    }

    @Override
    Pane getRoot() {
        return startRoot;
    }

    @Override
    public ViewType getViewType() {
        return ViewType.GAME_START;
    }

    @Override
    void keyPressed(KeyCode keyCode) {
    }

    @Override
    void activated() {

    }
    private void playButtonClicked(ActionEvent event) {
        viewSwitch.activateView(ViewType.GAME_FIELD);
        // viewModel.startGame();
        event.consume();
    }

}
