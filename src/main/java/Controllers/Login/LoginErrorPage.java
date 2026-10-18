package Controllers.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;

public class LoginErrorPage {
    public void btnOkOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Login/Login_page.fxml");

        Stage errorStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        errorStage.close();
    }
}
