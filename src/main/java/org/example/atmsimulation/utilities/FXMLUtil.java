package org.example.atmsimulation.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLUtil {
    LogUtil log = new LogUtil();

    public void loadScreen(Button btn, String fxml) {
        try {
            Parent screen = FXMLLoader.load(getClass().getResource("/org/example/atmsimulation/" + fxml + ".fxml"));
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.setScene(new Scene(screen));
            stage.show();
        } catch (IOException e) {
            log.writer("ERROR", "System", "FXML Yükleme Hatası" + " Dosya yüklenemedi: " + fxml);
        }
    }
}

