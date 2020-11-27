package com.soft;

import com.soft.model.Game;
import com.soft.view.GameFieldView;
import com.soft.view.SceneController;
import com.soft.view.View;
import com.soft.viewmodel.GameFieldViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static final int FIELD_WIDTH = 50;
    private static final int FIELD_HEIGHT = 50;
    private static final int GAME_OBJECT_WIDTH = 10;
    private static final int GAME_OBJECT_HEIGHT = 10;
    private static final String GAME_FIELD_FXML_PATCH = "fxml/game_field_view.fxml";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        initMVVM(stage);
        stage.show();
    }

    private void initMVVM(Stage stage) throws IOException {
        // model
        Game model = new Game(FIELD_WIDTH, FIELD_HEIGHT);
        // view model
        GameFieldViewModel gameFieldViewModel = new GameFieldViewModel(model);
        // view
        GameFieldView view = createGameFieldView(gameFieldViewModel);
        Scene scene = new Scene(view.getRoot());
        SceneController sceneController = new SceneController(scene);
        sceneController.addView(view);
        stage.setScene(scene);
    }

    private GameFieldView createGameFieldView(GameFieldViewModel viewModel) throws IOException {
        GameFieldView gameFieldView = new GameFieldView(viewModel);
        loadFXML(GAME_FIELD_FXML_PATCH, gameFieldView);
        int width = FIELD_WIDTH * GAME_OBJECT_WIDTH;
        int height = FIELD_HEIGHT * GAME_OBJECT_HEIGHT;
        gameFieldView.setGameFieldSize(width, height);
        gameFieldView.setGameObjectSize(GAME_OBJECT_WIDTH, GAME_OBJECT_HEIGHT);
        return gameFieldView;
    }

    private void loadFXML(String fxmlFilePath, View view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFilePath));
        fxmlLoader.setController(view);
        fxmlLoader.load();
    }

}