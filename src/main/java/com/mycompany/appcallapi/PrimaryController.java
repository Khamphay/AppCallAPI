package com.mycompany.appcallapi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {

    private Thread t2 = new Thread(new checkConnection(), "t2");
    public static String networkStats = "";
    private boolean fragMenu = false;
    private Node node;
    private Parent rootMenu = null;
    private HamburgerSlideCloseTransition hamberger_transition = null;
    

    @FXML
    private Text tvStatus;

    @FXML
    private BorderPane borderpane_Main;

    @FXML
    private JFXHamburger hamb_slide_menu;

    @FXML
    private ScrollPane scroll;

    @FXML
    private void switchToSecondary() throws IOException {
        // App.setRoot("secondary");
    }

    private void show_menuAll() {
        try {
            rootMenu = FXMLLoader.load(App.class.getResource("menu_2.fxml"));
            node = rootMenu;
            borderpane_Main.setLeft(node);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void show_menu() {
        try {
            if (fragMenu == true) {
                rootMenu = FXMLLoader.load(App.class.getResource("menu_1.fxml"));
                node = rootMenu;
                borderpane_Main.setLeft(node);
                fragMenu = false;
            } else {
                rootMenu = FXMLLoader.load(App.class.getResource("menu_2.fxml"));
                node = rootMenu;
                borderpane_Main.setLeft(node);
                fragMenu = true;
            }

            // ! Start set event to any button in node

            node.lookup("#btHome").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("home.fxml");
                }
            });

            node.lookup("#btCovid19").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("account.fxml");
                }
            });

            node.lookup("#btMember").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("member.fxml");
                }
            });

            node.lookup("#btManage").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("manage.fxml");
                }
            });

            node.lookup("#btProduct").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("product.fxml");
                }
            });

            node.lookup("#btImport").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("import.fxml");
                }
            });

            node.lookup("#btSale").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("sale.fxml");
                }
            });

            node.lookup("#btReport").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("report.fxml");
                }
            });

            node.lookup("#btSetting").setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    subForm("setting.fxml");
                }
            });

            // !End

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subForm(String fxml) {
        try {
            borderpane_Main.setCenter(loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Parent loadFXML(String fxmlFrom) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlFrom));
            return loader.load();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=====>" + e.getMessage());
            return null;
        }
    }

    private void sliderHamberger() {
        // Todo: hamberger translate
        hamberger_transition = new HamburgerSlideCloseTransition(hamb_slide_menu);
        hamberger_transition.setRate(-1);
        hamb_slide_menu.addEventHandler(MouseEvent.MOUSE_CLICKED, (eventHandler) -> {
            hamberger_transition.setRate(hamberger_transition.getRate() * -1);
            hamberger_transition.play();
            show_menu();
        });
    }

    @FXML
    private void openMenu(ActionEvent event) throws IOException {
        // Todo: Show or hide menu
        // sliderHamberger();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // show_menuAll();
        sliderHamberger();
        show_menu();
        tvStatus.setText(networkStats);
        t2.start();
    }

    // Todo: use Thrad for refresh data
    class checkConnection implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                    tvStatus.setText(networkStats);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
