package Controllers.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import scean.SceanManager;

import java.io.IOException;

public class BooksPageController {

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

    public void btnReturnBooksDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Return_Books_Page.fxml");
    }

    public void btnBookHistoryDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Books_History_Page.fxml");
    }

    public void btnIssueBooksDetailOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Books/Issue_Books_Page.fxml");
    }

    public void btnAddMemberSidebarOnAction(ActionEvent actionEvent) {
        SceanManager.switchPage("/view/Members/Add_Members_Page.fxml");
    }

    public void btnAddBooksOnAction(ActionEvent actionEvent) {
    }
}
