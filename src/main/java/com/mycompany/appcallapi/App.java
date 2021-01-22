package com.mycompany.appcallapi;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Scene scene;
    private Parent root;
    private double x, y;

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        root = FXMLLoader.load(App.class.getResource("login.fxml"));
        scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}