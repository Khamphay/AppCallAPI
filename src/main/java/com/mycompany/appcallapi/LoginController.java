package com.mycompany.appcallapi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    private Stage stagehome;

    @FXML
    private HBox login;

    @FXML
    private void Closed(ActionEvent event) {
        System.exit(0);
    }



    @FXML
    private void Login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(root);
        stagehome = new Stage();
        stagehome.setScene(scene);
        stagehome.show();

        //Todo: Close Form Login
        Stage closelogin = (Stage) login.getScene().getWindow();
        closelogin.close();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
    
}
