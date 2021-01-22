module com.mycompany.appcallapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.jfoenix;
    requires java.net.http;
    requires okhttp;
    requires json;
    
    opens com.mycompany.appcallapi to javafx.fxml;
    exports com.mycompany.appcallapi;
    
    opens com.mycompany.appcallapi.Controller to javafx.fxml;
    exports com.mycompany.appcallapi.Controller;
}
