module org.example.atmsimulation {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires org.controlsfx.controls;
    requires javafx.base;



    opens org.example.atmsimulation to javafx.fxml;
    exports org.example.atmsimulation;
    exports org.example.atmsimulation.controller;
    opens org.example.atmsimulation.controller to javafx.fxml;
}