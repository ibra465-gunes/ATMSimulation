package org.example.atmsimulation.services;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.atmsimulation.Launcher;
import org.example.atmsimulation.controller.LoginController;
import org.example.atmsimulation.model.Account;
import org.example.atmsimulation.utilities.AlertUtil;
import org.example.atmsimulation.utilities.LogUtil;
import org.example.atmsimulation.utilities.TransactionType;

import java.util.Date;

public class TransactionServices {
    AlertUtil alert = new AlertUtil();
    LogUtil log = new LogUtil();

    public void withDraw(String entryAmount, Label lbl, Button btn) {
        double amount = LoginController.tempAcc.getBalance();
        amount = amount - Double.valueOf(entryAmount);
        if (amount >= 0) {
            LoginController.tempAcc.setBalance(amount);
            lbl.setText(LoginController.tempAcc.getBalance() + "0" + " TL");
            alert.alert("ONAY", "İşlem gerçekleşti", btn);
            log.writer("INFO", LoginController.tempAcc.getAccountId(), "Para çekme işlemi gerçekleşti.");
            LoginController.tempAcc.setTransaction(Double.valueOf(entryAmount), TransactionType.WITHDRAW, new Date(), "Para çekme", LoginController.tempAcc.getAccountId());
        } else {
            alert.alert("UYARI", "Yeterli bakiye yok", btn);
            log.writer("WARN", LoginController.tempAcc.getAccountId(), "Yetersiz bakiye.");
        }
    }

    public void deposit(String entryAmount, Button btn) {
        double amount = LoginController.tempAcc.getBalance();
        amount = amount + Double.valueOf(entryAmount);
        LoginController.tempAcc.setBalance(amount);
        alert.alert("ONAY", "İşlem gerçekleşti", btn);
        log.writer("INFO", LoginController.tempAcc.getAccountId(), "Para yatırma işlemi gerçekleşti.");
        LoginController.tempAcc.setTransaction(Double.valueOf(entryAmount), TransactionType.DEPOSIT, new Date(), "Para yatırma", LoginController.tempAcc.getAccountId());
    }

    public void transfer(TextField txtAccountId, TextField txtEntryAmount, Button btn) {
        Account transactionAccount;
        Boolean found = false;
        for (Account acc : Launcher.accounts) {
            if (acc.getAccountId().equals(txtAccountId.getText())) {
                transactionAccount = acc;
                found = true;
                if (LoginController.tempAcc.getBalance() > Double.parseDouble(txtEntryAmount.getText())) {
                    LoginController.tempAcc.setBalance(LoginController.tempAcc.getBalance() - Double.parseDouble(txtEntryAmount.getText()));
                    transactionAccount.setBalance(transactionAccount.getBalance() + Double.parseDouble(txtEntryAmount.getText()));
                    alert.alert("ONAY", "İşlem gerçekleşti", btn);
                    log.writer("INFO", LoginController.tempAcc.getAccountId(), "Para gönderme işlemi " + "[" + txtAccountId.getText() + "]" + "'e gerçekleşti.");
                    LoginController.tempAcc.setTransaction(Double.valueOf(txtEntryAmount.getText()), TransactionType.TRANSFER, new Date(), "Para gönderme", txtAccountId.getText());
                    txtAccountId.setText("");
                    txtEntryAmount.setText("");
                } else {
                    alert.alert("UYARI", "Yeterli bakiye yok", btn);
                    log.writer("WARN", LoginController.tempAcc.getAccountId(), "Yetersiz bakiye.");
                }
                break;
            }
        }
        if (!found) {
            alert.alert("HATA", "Böyle bir hesap yok", btn);
            log.writer("ERROR", LoginController.tempAcc.getAccountId(), "Böyle bir hesap yok " + "[" + txtAccountId.getText() + "]");
        }
    }
}
