package Controllers.Members;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;

public class MembersPageController {

    @FXML
    public TableColumn<?,?>colMemberId;

    @FXML
    public TableColumn<?,?>colMemberName;

    @FXML
    public TableColumn<?,?>colMemberEmail;

    @FXML
    public TableColumn<?,?>colMemberPhoneNum;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMember;

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
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
    public void btnMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnAddMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }
}
