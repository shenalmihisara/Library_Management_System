package Controllers.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.LoginDTO;
import scean.SceanManager;

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

        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUserName(txtUserName.getText());
        loginDTO.setPassword(txtPassword.getText());

        if (loginController.CheckUserNameAndPassword(loginDTO)) {
            SceanManager.switchPage("/view/Home/Home_Page.fxml");
        }else {
            SceanManager.switchPage("/view/Login/Login_error_page.fxml");

        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Login/Login_page.fxml");
    }
}
