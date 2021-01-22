package com.mycompany.appcallapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.http.HttpClient;

import com.mycompany.appcallapi.model.Covid19_API_Connector;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * JavaFX App
 */
public class App extends Application {

    private  Scene scene;
    private Parent root;
    private double x, y;

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder().GET().uri(URI.create(Covid19_API_Connector.getCallAPI("/all"))).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("Connect succesfully "+ response.statusCode());
        } else {
            System.out.println("Connect Fail" + response.statusCode());
        }

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