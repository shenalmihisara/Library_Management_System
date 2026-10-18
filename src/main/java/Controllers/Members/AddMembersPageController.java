package Controllers.Members;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;

public class AddMembersPageController {
    Stage stage = new Stage();
    AddMemberController addMemberController = new AddMemberController();

    @FXML
    public TextField txtId;
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtEmail;
    @FXML
    public TextField txtPhoneNumber;
    @FXML
    public TextField txtAddress;
    @FXML
    public Button btnMemberRegister;


    public void btnMemberRegisterOnAction(ActionEvent actionEvent) {
        addMemberController.addMembers(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                txtPhoneNumber.getText()
        );
    }

    public void btnCancleMemberFormOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    public void btnAddMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    public void btnHomeOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Home/Home_Page.fxml");
    }

    public void btnMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    public void btnBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Login/Login_page.fxml");
    }
}
