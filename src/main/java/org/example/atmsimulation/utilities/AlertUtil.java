package org.example.atmsimulation.utilities;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class AlertUtil {
    public void alert(String type, String message, Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        Notifications alert = Notifications.create().owner(stage);
        alert.title(type);
        alert.text(message);
        alert.position(Pos.BOTTOM_CENTER);
        alert.hideAfter(Duration.seconds(3));
        if (type.equals("HATA"))
            alert.showError();
        else if (type.equals("UYARI"))
            alert.showWarning();
        else
            alert.showConfirm();
    }
}
