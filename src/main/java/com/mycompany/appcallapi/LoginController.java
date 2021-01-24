package com.mycompany.appcallapi;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSpinner;
import com.mycompany.appcallapi.model.Covid19_API_Connector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController implements Initializable {
    
    private Stage stagehome;
    private Thread t1 = new Thread(new checkConnection(), "t1");

    @FXML
    private HBox login;

    @FXML
    private JFXSpinner sniperCheck;

    @FXML
    private void Closed(ActionEvent event) {
        t1.stop();
        System.exit(0);
    }

    @FXML
    private void Login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(root);
        stagehome = new Stage();
        stagehome.setScene(scene);
        stagehome.show();

        //Todo: Set event windown clase
        stagehome.setOnCloseRequest( new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

        //Todo: Close Form Login
        t1.stop();
        Stage closelogin = (Stage) login.getScene().getWindow();
        closelogin.close();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       // sniperCheck.setVisible(true);
        t1.start();
    }

    // Todo: use Thrad for refresh data
    class checkConnection implements Runnable {
        @Override
        public void run() {
            try {
<<<<<<< HEAD
                var client = HttpClient.newBuilder().build();
                var request = HttpRequest.newBuilder().GET()
                        .uri(URI.create(Covid19_API_Connector.getCallAPI("/all"))).build();
                var response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    PrimaryController.networkStats = "ການເຊື່ອມ NovelCOVID API ຕໍ່ສຳເລັດແລ້ວ";
                    System.out.println("Connect succesfully" + response.statusCode());
                    // sniperCheck.setVisible(false);
                } else {
                    PrimaryController.networkStats = "ບໍ່ສາມາດເຊື່ອມຕໍ່ NovelCOVID API (ກະລຸນາກວດສອບເຊື່ອມຕໍ່ Network)";
                    System.out.println("Connect Fail" + response.statusCode());
                }
            } catch (Exception e) {
                PrimaryController.networkStats = "ບໍ່ສາມາດເຊື່ອມຕໍ່ NovelCOVID API (ກະລຸນາກວດສອບເຊື່ອມຕໍ່ Network)";
                System.err.println("Connection error: " + e.getMessage() + " (Please chacek internet connection.)");
=======
                Thread.sleep(3000);
                try {
                    var client = HttpClient.newBuilder().build();
                    var request = HttpRequest.newBuilder().GET()
                            .uri(URI.create(Covid19_API_Connector.getCallAPI("/all"))).build();
                    var response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    if (response.statusCode() == 200) {
                        System.out.println("Connect succesfully " + response.statusCode());
                       // sniperCheck.setVisible(false);
                    } else {
                        System.out.println("Connect Fail" + response.statusCode());
                    }
                } catch (Exception e) {
                    System.err.println("Connection error: " + e.getMessage() + " (Please chacek internet connection.)");
                }
            } catch (InterruptedException e) {
                System.err.println("Thread error: " + e.getMessage());
>>>>>>> 22c144cc6ec5a9d5a03570e3fc0629787ebad7bc
            }
        }
    }
    
}
