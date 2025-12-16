package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.atmsimulation.services.TransactionServices;
import org.example.atmsimulation.utilities.FXMLUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML
    private Label lblName;
    @FXML
    private Label lblAccounId;
    @FXML
    private Label lblBalance;
    @FXML
    private Button btnAccount;
    @FXML
    private Button btnWithdrawMoney;
    @FXML
    private TextField txtEntryAmount;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnDepositScreen;
    @FXML
    private Button btnFifty;
    @FXML
    private Button btnTwoHunderd;
    @FXML
    private Button btnFiveHundred;
    @FXML
    private Button btnOneThousand;
    @FXML
    private Button btnTransaction;
    TransactionServices transactionServices = new TransactionServices();
    FXMLUtil fxmlUtil = new FXMLUtil();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblName.setText(LoginController.tempAcc.getName() + " " + LoginController.tempAcc.getSurname());
        String lastFour = LoginController.cardId.substring(LoginController.cardId.length() - 4);
        lblAccounId.setText(" (**** " + lastFour + ")");
        lblBalance.setText(LoginController.tempAcc.getBalance() + "0" + " TL");
        btnWithdrawMoney.disableProperty().bind(txtEntryAmount.textProperty().isEmpty());
    }

    @FXML
    private void handleLogout() {
        fxmlUtil.loadScreen(btnLogout, "Login");
    }

    @FXML
    private void handleAccountAndCards(){
        fxmlUtil.loadScreen(btnAccount, "AccountsAndCards");
    }

    @FXML
    private void handleDepositScreen() {
        fxmlUtil.loadScreen(btnDepositScreen, "DepositScreen");
    }

    @FXML
    private void handleTransaction() {
        fxmlUtil.loadScreen(btnTransaction, "TransactionScreen");
    }

    @FXML
    private void handleWithdrawMoney() {
        transactionServices.withDraw(txtEntryAmount.getText(),lblBalance,btnAccount);
        txtEntryAmount.setText("");
    }

    @FXML
    private void handleWithdrawMoney1() {
        transactionServices.withDraw("50",lblBalance,btnAccount);
    }

    @FXML
    private void handleWithdrawMoney2() {
        transactionServices.withDraw("200",lblBalance,btnAccount);
    }

    @FXML
    private void handleWithdrawMoney3() {
        transactionServices.withDraw("500",lblBalance,btnAccount);
    }

    @FXML
    private void handleWithdrawMoney4() {
        transactionServices.withDraw("1000",lblBalance,btnAccount);
    }
}
