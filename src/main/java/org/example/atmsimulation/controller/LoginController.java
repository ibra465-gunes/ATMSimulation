package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.atmsimulation.Launcher;
import org.example.atmsimulation.model.Account;
import org.example.atmsimulation.model.Card;
import org.example.atmsimulation.utilities.AlertUtil;
import org.example.atmsimulation.utilities.FXMLUtil;
import org.example.atmsimulation.utilities.LogUtil;

import java.util.*;

public class LoginController {
    public static Account tempAcc;
    public static String cardId;
    @FXML
    private TextField txtCardNo;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnGiris;
    AlertUtil alert = new AlertUtil();
    LogUtil log = new LogUtil();
    FXMLUtil fxmlUtil = new FXMLUtil();

    @FXML
    private void handleLogin() {
        String password = null;
        for (Account acc : Launcher.accounts) {
            cardId = acc.getCard().stream().filter(a -> a.getCardId().equals(txtCardNo.getText())).map(Card::getCardId).findFirst().orElse(null);
            password = acc.getCard().stream().filter(b -> b.getPassword().equals(txtPassword.getText())).map(Card::getPassword).findFirst().orElse(null);
            if (cardId != null) {
                tempAcc = acc;
                break;
            }
        }
        if (cardId == null || password == null) {
            alert.alert("HATA", "Kart numarası ya da şifre hatalı", btnGiris);
            log.writer("ERROR", "", "Kart numarası ya da şifre hatalı");
        } else if (cardId.equals(txtCardNo.getText()) && password.equals(txtPassword.getText())) {
            fxmlUtil.loadScreen(btnGiris, "MainScreen");
        }
    }
}
