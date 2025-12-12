package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML private Label lblName;
    @FXML private Label lblAccounId;
    @FXML private Label lblBalance;
    @FXML private Button btnAccount;
    @FXML private Button btnTakeMoney;
    @FXML private TextField txtEntryAmount;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblName.setText(LoginController.tempAcc.getName()+" "+LoginController.tempAcc.getSurname());
        String lastFour = LoginController.cardId.substring(LoginController.cardId.length()-4);
        lblAccounId.setText(" (****"+lastFour+")");
        lblBalance.setText(String.valueOf(LoginController.tempAcc.getBalance()));
        btnTakeMoney.disableProperty().bind(txtEntryAmount.textProperty().isEmpty());
    }
}
