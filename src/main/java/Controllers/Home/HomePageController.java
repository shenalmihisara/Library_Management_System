package Controllers.Home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    HomeController homeController = new HomeController();

    @FXML
    public Label lblBorrowedBookCount;

    @FXML
    public Label lblOverdueBookCount;

    @FXML
    public Label lblMemberCount;

    @FXML
    public Label lblBookCount;

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
    void btnMemberOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Members/Members_page.fxml");
    }

    @FXML
    public void btnAddMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    @FXML
    public void btnAddBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Add_Books_Page.fxml");
    }

    @FXML
    public void btnDeleteMemberOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Delete_Member_page.fxml" );
    }

    @FXML
    public void btnDeleteBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
    }

    public void btnIssueBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Issue_Books_Page.fxml");
    }

    public void btnReturnBooksOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Return_Books_Page.fxml");
    }

    public void btnBookHistoryOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_History_Page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblMemberCount.setText(String.valueOf(homeController.memberCount()));
        lblBookCount.setText(String.valueOf(homeController.bookCount()));
    }
}
