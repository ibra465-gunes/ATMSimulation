package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.atmsimulation.model.Account;
import org.example.atmsimulation.model.Card;

import java.io.IOException;
import java.time.YearMonth;
import java.util.*;

public class LoginController {
    public List<Account> accounts = new ArrayList<>();
    static Account tempAcc;
    public static String cardId;
    @FXML private TextField txtCardNo;
    @FXML private TextField txtPassword;
    @FXML private Button btnGiris;
    @FXML private void handleLogin() throws IOException {
        String password = null;

        for (Account acc: accounts){
            cardId = String.valueOf(acc.getCard().stream().filter(a -> a.getCardId().equals(txtCardNo.getText())).map(Card::getCardId).findFirst().orElse(null));
            password = String.valueOf(acc.getCard().stream().filter(b -> b.getPassword().equals(txtPassword.getText())).map(Card::getPassword).findFirst().orElse(null));
            if(cardId != null){
                tempAcc = acc;
                break;
            }
        }
        if (cardId == null){
            Account newAccount = new Account("123456789","Hasan","Kaya");
            newAccount.setCardIds(txtCardNo.getText(), txtPassword.getText(),123, YearMonth.of(2028,12), newAccount.getAccountId());
            cardId = txtCardNo.getText();
            password = txtPassword.getText();
            tempAcc = newAccount;
        }
        if (cardId.equals(txtCardNo.getText()) && password.equals(txtPassword.getText())){
            Parent screen = FXMLLoader.load(getClass().getResource("/org/example/atmsimulation/MainScreen.fxml"));
            Stage stage = (Stage) btnGiris.getScene().getWindow();
            stage.setScene(new Scene(screen));
            stage.show();
        }
    }
}
