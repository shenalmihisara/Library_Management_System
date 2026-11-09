package Controllers.Books;

import Controllers.Alert.AlertUtill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import scean.SceanManager;

public class DeleteBooksPageController {

    DeleteBooksController deleteBooksController = new DeleteBooksController();

    @FXML
    public TextField txtBookName;

    @FXML
    public TextField txtBookId;

    @FXML
    public TextField txtReEnterBookId;

    @FXML
    private Button btnAddBooks;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnCancleDeleteBooks;

    @FXML
    private Button btnDeleteBooks;

    @FXML
    private Button btnDeleteBooksData;

    @FXML
    private Button btnDeleteMember;

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
    void btnDeleteBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Delete_Books_Page.fxml");
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
    void btnCancleDeleteBooksOnAction(ActionEvent event) {
        SceanManager.switchPage("/view/Books/Books_Page.fxml");
    }

    @FXML
    void btnDeleteBooksDataOnAction(ActionEvent event) {
        if (deleteBooksController.checkBookNameAndBookId(
                txtBookName.getText(), txtBookId.getText(), txtReEnterBookId.getText())){
            AlertUtill.showAlert(Alert.AlertType.INFORMATION,
                    "Sucess",
                    "Member Deleted Sucessfully");

            txtBookName.clear();
            txtBookId.clear();
            txtReEnterBookId.clear();

        }else {
            AlertUtill.showAlert(Alert.AlertType.ERROR,
                    "Error",
                    "Book Name Or Id Is Invalide");
        }
    }

}