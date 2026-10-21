package Controllers.Members;

import Controllers.Alert.AlertUtill;
import Controllers.Login.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import scean.SceanManager;

public class DeleteMemberPageController {
    DeleteMemberController deleteMemberController = new DeleteMemberController();
    
    @FXML
    public TextField txtMemberName;

    @FXML
    public TextField txtMemberId;

    @FXML
    public TextField txtReEnterMemberId;

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnCancleDeleteMember;

    @FXML
    private Button btnDeleteMember;

    @FXML
    private Button btnDeleteMemberData;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    @FXML
    void btnAddBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnCancleDeleteMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    @FXML
    void btnDeleteMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Home/Home_Page.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Login/Login_page.fxml");
    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    @FXML
    void btnDeleteMemberDataOnAction(ActionEvent event) {
        if (deleteMemberController.CheckMemberNameAndMemberidAndReEntterMemberId(
                txtMemberName.getText(), txtMemberId.getText(),txtMemberId.getText())){
            AlertUtill.showAlert(Alert.AlertType.INFORMATION,
                    "Sucess",
                    "Member Deleted Sucessfully"
            );

            txtMemberName.clear();
            txtMemberId.clear();
            txtReEnterMemberId.clear();

        }else {
            AlertUtill.showAlert(Alert.AlertType.ERROR,
                    "Wrong",
                    "Your name or id is invalid"
            );
        }
    }

}
