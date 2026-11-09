package Controllers.Alert;

import javafx.scene.control.Alert;

public class AlertUtill {
    public static void showAlert(
      Alert.AlertType type,
      String title,
      String message
    ){
        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
