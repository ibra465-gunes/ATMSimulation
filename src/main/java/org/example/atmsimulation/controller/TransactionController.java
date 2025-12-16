package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.atmsimulation.services.TransactionServices;
import org.example.atmsimulation.utilities.FXMLUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {
    @FXML
    private TextField txtAccountId;
    @FXML
    private TextField txtEntryAmount;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnBack;
    TransactionServices transactionServices = new TransactionServices();
    FXMLUtil fxmlUtil = new FXMLUtil();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnConfirm.disableProperty().bind(txtEntryAmount.textProperty().isEmpty());
    }

    @FXML
    private void handleTransactionConfirm() {
        transactionServices.transfer(txtAccountId, txtEntryAmount, btnConfirm);
    }

    @FXML
    private void handleBack() {
        fxmlUtil.loadScreen(btnBack, "MainScreen");
    }
}
