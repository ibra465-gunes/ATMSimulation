package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML private Label lblName;
    @FXML private Label lblAccounId;
    @FXML private Label lblBalance;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblName.setText(" İbrahim Güneş");
        lblAccounId.setText(" (**** 5050)");
        lblBalance.setText("6000.00 TL");
    }
}
