module com.mycompany.appcallapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires com.jfoenix;
    requires java.net.http;
    requires okhttp;
    requires json;
    requires unirest.java;


    opens com.mycompany.appcallapi to javafx.fxml;
    exports com.mycompany.appcallapi;
    
    opens com.mycompany.appcallapi.Controller to javafx.fxml;
    exports com.mycompany.appcallapi.Controller;
}
