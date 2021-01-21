package com.mycompany.appcallapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private  Scene scene;
    private  Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        root = FXMLLoader.load(App.class.getResource("primary.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}