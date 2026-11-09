package Controllers.Members;

import Controllers.Alert.AlertUtill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MemberDTO;
import scean.SceanManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMembersPageController implements Initializable {

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

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberId(txtId.getText());
        memberDTO.setFullName(txtName.getText());
        memberDTO.setAddress(txtAddress.getText());
        memberDTO.setEmail(txtEmail.getText());
        memberDTO.setPhoneNumber(txtPhoneNumber.getText());



        if (memberDTO.getMemberId() == null || memberDTO.getMemberId().trim().isEmpty() ||
                memberDTO.getFullName() == null || memberDTO.getFullName().trim().isEmpty() ||
                memberDTO.getAddress() == null || memberDTO.getAddress().trim().isEmpty() ||
                memberDTO.getEmail() == null || memberDTO.getEmail().trim().isEmpty() ||
                memberDTO.getPhoneNumber() == null || memberDTO.getPhoneNumber().trim().isEmpty()
        ){
            AlertUtill.showAlert(Alert.AlertType.WARNING, "WARNING", "Fill All Requid Fields");

            return;
        }

        boolean MemberAdded = addMemberController.addMembers(memberDTO);

        if (MemberAdded){
            AlertUtill.showAlert(Alert.AlertType.INFORMATION,
                    "SUCESS!",
                    "Sucessfully Add Member!  Your Member Id : " + memberDTO.getMemberId());
        } else {
            AlertUtill.showAlert(Alert.AlertType.ERROR,
                    "Error",
                    "Faild to add Student"
            );
        }

        txtName.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtPhoneNumber.clear();

        txtId.setText(addMemberController.genarateMemberId());
        txtId.setEditable(false);
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

    public void btnAddBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    public void btnDeleteMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }

    public void btnDeleteBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtId.setText(addMemberController.genarateMemberId());
        txtId.setEditable(false);
    }
}
