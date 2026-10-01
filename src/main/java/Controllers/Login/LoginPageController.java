package Controllers.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {

    LoginController loginController = new LoginController();

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if (loginController.CheckUserNameAndPassword(txtUserName.getText(),txtPassword.getText())) {
            Stage stage = new Stage();
            stage.show();

            Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            errorStage.close();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Home/Home_Page.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Login/Login_error_page.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
            Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            errorStage.close();

        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Login/Login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        errorStage.close();
    }
}
