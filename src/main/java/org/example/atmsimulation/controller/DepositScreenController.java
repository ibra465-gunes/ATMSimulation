package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.atmsimulation.services.TransactionServices;
import org.example.atmsimulation.utilities.FXMLUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class DepositScreenController implements Initializable {
    @FXML
    private Button btnBack;
    @FXML
    private Button btnDeposit;
    @FXML
    private TextField txtEntryAmount;
    TransactionServices transactionServices = new TransactionServices();
    FXMLUtil fxmlUtil = new FXMLUtil();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnDeposit.disableProperty().bind(txtEntryAmount.textProperty().isEmpty());
    }

    @FXML
    private void handleBack() {
        fxmlUtil.loadScreen(btnBack, "MainScreen");
    }

    @FXML
    private void handleDeposit() {
        transactionServices.deposit(txtEntryAmount.getText(), btnDeposit);
        txtEntryAmount.setText("");
    }
}
