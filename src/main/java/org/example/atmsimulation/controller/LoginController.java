package org.example.atmsimulation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML private TextField txtCardNo;
    @FXML private  TextField txtPassword;
    @FXML private Button btnGiris;
    private String CardId = "123456789";
    private String password = "1234";
    @FXML private void handleLogin() throws IOException {
        if (CardId.equals(txtCardNo.getText()) && password.equals(txtPassword.getText())){
            Parent screen = FXMLLoader.load(getClass().getResource("/org/example/atmsimulation/MainScreen.fxml"));
            Stage stage = (Stage) btnGiris.getScene().getWindow();
            stage.setScene(new Scene(screen));
            stage.show();
        }
    }
}
