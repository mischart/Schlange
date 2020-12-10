package com.soft;

import com.soft.model.Game;
import com.soft.view.GameFieldView;
import com.soft.view.GameStartView;
import com.soft.view.SceneController;
import com.soft.view.View;
import com.soft.viewmodel.GameFieldViewModel;
import com.soft.viewmodel.GameStartViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application {

    private static final int FIELD_WIDTH = 50;
    private static final int FIELD_HEIGHT = 50;
    private static final int GAME_OBJECT_WIDTH = 10;
    private static final int GAME_OBJECT_HEIGHT = 10;
    private static final String GAME_FIELD_FXML_PATCH = "fxml/game_field_view.fxml";
    private static final String GAME_START_FXML_PATCH = "fxml/game_start_view.fxml";
    private static final String STRING_RESOURCE_PATCH = "com.soft.strings.strings";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        initMVVM(stage);
        stage.show();
    }

    private void initMVVM(Stage stage) throws IOException {
        // create model
        Game model = new Game(FIELD_WIDTH, FIELD_HEIGHT);
        // create view models
        GameFieldViewModel gameFieldViewModel = new GameFieldViewModel(model);
        GameStartViewModel gameStartViewModel = new GameStartViewModel(model);
        // create views
        GameStartView gameStartView = createGameStartView(gameStartViewModel);
        GameFieldView view = createGameFieldView(gameFieldViewModel);
        // create scene
        Scene scene = new Scene(view.getRoot());
        // set scene
        stage.setScene(scene);
        // create scene controller
        SceneController sceneController = new SceneController(stage);
        // set scene controller
        gameStartView.setViewSwitch(sceneController);
        view.setViewSwitch(sceneController);
        // add views
        sceneController.addView(view);
        sceneController.addView(gameStartView);
        // activate view
        sceneController.activateView(gameStartView.getViewType());

    }

    private GameFieldView createGameFieldView(GameFieldViewModel viewModel) throws IOException {
        GameFieldView gameFieldView = new GameFieldView(viewModel);
        gameFieldView.setGameObjectSize(GAME_OBJECT_WIDTH, GAME_OBJECT_HEIGHT);
        loadFXML(GAME_FIELD_FXML_PATCH, gameFieldView);
        int width = FIELD_WIDTH * GAME_OBJECT_WIDTH;
        int height = FIELD_HEIGHT * GAME_OBJECT_HEIGHT;
        gameFieldView.setGameFieldSize(width, height);
        return gameFieldView;
    }

    // TODO: extract this method from createGameFieldView
    private GameStartView createGameStartView(GameStartViewModel viewModel) throws IOException {
        GameStartView view = new GameStartView(viewModel);
        loadFXML(GAME_START_FXML_PATCH, view);
        return view;
    }

    private void loadFXML(String fxmlFilePath, View view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFilePath));
        fxmlLoader.setController(view);
        ResourceBundle resourceBundle = ResourceBundle.getBundle(STRING_RESOURCE_PATCH, Locale.GERMAN);
        fxmlLoader.setResources(resourceBundle);
        fxmlLoader.load();
    }

}