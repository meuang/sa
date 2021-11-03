module com.example.headjavafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.headjavafx to javafx.fxml;
//    opens com.example.headjavafx.controller to javafx.fxml;
    opens com.example.headjavafx.model to javafx.fxml;
    exports com.example.headjavafx;
//    exports com.example.headjavafx.controller;
    exports com.example.headjavafx.model;
}