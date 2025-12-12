package org.example.atmsimulation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ATMApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ATMApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 420);
        stage.setTitle("ATM");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icons/atm.png")));
        stage.setScene(scene);
        stage.show();
    }
}
